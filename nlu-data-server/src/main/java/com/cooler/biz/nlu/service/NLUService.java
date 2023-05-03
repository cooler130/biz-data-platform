package com.cooler.biz.nlu.service;


import com.cooler.ai.nlu.DomainInfo;
import com.cooler.ai.nlu.SlotInfo;

import java.util.List;
import java.util.Map;

public interface NLUService {

    List<DomainInfo> parseDomainIntent(String sentence);

    List<DomainInfo> parseDomainIntentWithContext(String sentence, String domain);

    Map<Integer, SlotInfo> parseSlotWithContext(String sentence, String domain);

}
