package com.cooler.biz.nlu.controller;

import com.alibaba.fastjson.JSON;
import com.cooler.ai.nlu.DomainInfo;
import com.cooler.ai.nlu.SlotInfo;
import com.cooler.biz.auth.annotation.Auth;
import com.cooler.biz.base.entity.Result;
import com.cooler.biz.nlu.service.NLUService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nlu")
public class NLUController {
    @Autowired
    private NLUService nluService;
    private static Logger logger =  LoggerFactory.getLogger(NLUController.class);


    /**
     * 不带领域（上下文）的意图识别
     * @param sId
     * @param sentence
     * @return
     */
    @GetMapping("/queryIntent/{sentence}")
    public Result queryIntent(@Auth(required = false) Long sId, @PathVariable("sentence") String sentence) {
        List<DomainInfo> domainInfos = nluService.parseDomainIntent(sentence);
        logger.info("\n -> /nlu/queryIntent/{} \n  -->  {} ", sentence, JSON.toJSONString(domainInfos));

        return new Result().success(domainInfos);
    }

    /**
     * 带上领域（上下文）的意图识别
     * @param sId
     * @param domain
     * @param sentence
     * @return
     */
    @GetMapping("/queryIntentWithContext/{sentence}/{domain}")
    public Result queryIntentWithContext(@Auth(required = false) Long sId, @PathVariable("domain") String domain, @PathVariable("sentence") String sentence) {
        List<DomainInfo> domainInfos = nluService.parseDomainIntentWithContext(sentence, domain);
        logger.info("\n -> /nlu/queryIntentWithContext/{}/{} \n  -->  {} ", sentence, domain, JSON.toJSONString(domainInfos));

        return new Result().success(domainInfos);
    }

    /**
     * 做NER必须输入领域
     * @param sId
     * @param domain
     * @param sentence
     * @return
     */
    @GetMapping("/querySlotsWithContext/{sentence}/{domain}")
    public Result querySlotsWithContext(@Auth(required = false) Long sId, @PathVariable("domain") String domain, @PathVariable("sentence") String sentence) {
        Map<Integer, SlotInfo> slotInfoMap = nluService.parseSlotWithContext(sentence, domain);
        logger.info("\n -> /nlu/querySlotsWithContext/{}/{} \n  -->  {} ", sentence, domain, JSON.toJSONString(slotInfoMap));

        return new Result().success(slotInfoMap);
    }

}
