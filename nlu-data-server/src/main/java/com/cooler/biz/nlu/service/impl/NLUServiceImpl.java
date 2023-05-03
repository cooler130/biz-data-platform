package com.cooler.biz.nlu.service.impl;

import com.cooler.ai.nlu.DomainInfo;
import com.cooler.ai.nlu.SlotInfo;
import com.cooler.biz.nlu.service.NLUDataService;
import com.cooler.biz.nlu.service.NLUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NLUServiceImpl implements NLUService {

    @Autowired
    private NLUDataService NLUDataService;

    @Override
    public List<DomainInfo> parseDomainIntent(String sentence) {
        return parseDomainIntentWithContext(sentence, null);
    }


    @Override
    public List<DomainInfo> parseDomainIntentWithContext(String sentence, String domain) {
        List<DomainInfo> domainInfos = domainIntentRecognize(sentence, domain);
        Map<Integer, SlotInfo> slotInfoMap = namedEntityRecognize(sentence, domain);

        List<DomainInfo> domainInfosTmp = new ArrayList<>();
        for (DomainInfo domainInfo : domainInfos) {
            DomainInfo domainInfoTmp = new DomainInfo();
            domainInfoTmp.setUuid(domainInfo.getUuid());
            domainInfoTmp.setNluDomainName(domainInfo.getNluDomainName());
            domainInfoTmp.setNluIntentName(domainInfo.getNluIntentName());
            domainInfoTmp.setScore(domainInfo.getScore());
            if(slotInfoMap != null && slotInfoMap.size() > 0){
                domainInfoTmp.setSlots(slotInfoMap);
            }
            domainInfosTmp.add(domainInfoTmp);
        }
        return domainInfosTmp;
    }

    @Override
    public Map<Integer, SlotInfo> parseSlotWithContext(String sentence, String domain) {
        Map<Integer, SlotInfo> slotInfoMap = namedEntityRecognize(sentence, domain);
        return slotInfoMap;
    }

    /**
     * 领域意图识别
     * @param query
     * @param domain
     * @return
     */
    private List<DomainInfo> domainIntentRecognize(String query, String domain){
        DomainInfo domainInfo = null;
        Map<String, Map<String, DomainInfo>> fatherDIMap = NLUDataService.getFatherDIMap();

        if(domain == null){
            Set<String> domains = fatherDIMap.keySet();
            for (String domainTmp : domains) {
                Map<String, DomainInfo> bizDomainInfoMap = fatherDIMap.get(domainTmp);  //此处模拟发往所有领域的nlu服务进行解析
                if(bizDomainInfoMap != null) {
                    domainInfo = bizDomainInfoMap.get(query);
                    if(domainInfo != null) return Arrays.asList(domainInfo);
                }
            }
        } else {
            Map<String, DomainInfo> bizDomainInfoMap = fatherDIMap.get(domain);
            if(bizDomainInfoMap != null){
                domainInfo = bizDomainInfoMap.get(query);
                if(domainInfo != null) {
                    return Arrays.asList(domainInfo);
                }
            }
            bizDomainInfoMap = fatherDIMap.get(NLUDataServiceImpl.NO_DOMAIN);
            if(bizDomainInfoMap != null){
                domainInfo = bizDomainInfoMap.get(query);
                if(domainInfo != null) {
                    return Arrays.asList(domainInfo);
                }
            }
            //todo：这里附加的除了no_doamin，还可能有其他领域的解析，例如判断是否...，可以一个个加进来，以后可以形成nlu解析引擎
        }
        return new ArrayList<>();
    }

    /**
     * 命名实体识别
     * @param query
     * @param domain
     * @return
     */
    private Map<Integer, SlotInfo> namedEntityRecognize(String query, String domain){
        Map<String, Map<String, List<SlotInfo>>> fatherSMap = NLUDataService.getFatherSMap();
        if(domain != null){
            Map<String, List<SlotInfo>> bizSListMap = fatherSMap.get(domain);
            if(bizSListMap != null) {
                List<SlotInfo> slotInfos = bizSListMap.get(query);
                if(slotInfos != null){
                    Map<Integer, SlotInfo> slotInfoMap = new HashMap<>();
                    int i = 1;
                    for (SlotInfo slotInfo : slotInfos) {
                        slotInfoMap.put(i ++, slotInfo);
                    }
                    return slotInfoMap;
                }
            }
        }
        return new HashMap<>();
    }
}
