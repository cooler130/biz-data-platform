package com.cooler.ai.nlg.dao;

import com.cooler.ai.nlg.entity.GuideOption;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface GuideOptionMapper {

    List<GuideOption> getGuideOptions(@Param("nlgId") Integer nlgId);

}