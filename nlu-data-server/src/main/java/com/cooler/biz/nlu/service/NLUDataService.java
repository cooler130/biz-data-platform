package com.cooler.biz.nlu.service;

import com.cooler.ai.nlu.DomainInfo;
import com.cooler.ai.nlu.SlotInfo;

import java.util.List;
import java.util.Map;

public interface NLUDataService {
    Map<String, Map<String, DomainInfo>> getFatherDIMap();

    Map<String, Map<String, List<SlotInfo>>> getFatherSMap();
}
