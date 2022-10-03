package com.cooler.ai.nlg.dao;

import com.cooler.ai.nlg.entity.GuideOption;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideOptionMapper {

    List<GuideOption> getGuideOptions(@Param("nlgId") Integer nlgId);

}