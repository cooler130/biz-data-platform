package com.cooler.biz.nlu.controller;

import com.alibaba.fastjson.JSON;
import com.cooler.ai.burouter.BuDataInfo;
import com.cooler.ai.burouter.OrderDataInfo;
import com.cooler.ai.burouter.TQDataInfo;
import com.cooler.ai.burouter.dto.BuDataDto;
import com.cooler.ai.burouter.dto.OrderDataDto;
import com.cooler.ai.burouter.dto.TqDataDto;
import com.cooler.biz.auth.annotation.Auth;
import com.cooler.biz.base.entity.Result;
import com.cooler.biz.nlu.service.Burouter2DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.*;

@RestController
@RequestMapping("/burouter2")
public class Burouter2Controller {
    @Autowired
    private Burouter2DataService burouter2DataService;

    private static Logger logger =  LoggerFactory.getLogger(Burouter2DataService.class);


    @PostMapping("/getTop1TqData")
    public Result getTop1TqData(@Auth(required = false) Long sId, @Validated @RequestBody String requestBody) {
        TqDataDto tqDataDto = JSON.parseObject(requestBody, TqDataDto.class);
        @NotBlank String sentence = tqDataDto.getSentence();
        @NotBlank String excludeTqIdsStr = tqDataDto.getExcludeTqIds();
        Set<String> excludeTqIds = excludeTqIdsStr != null ? new HashSet<>(Arrays.asList(excludeTqIdsStr.split(","))) : null;

        TQDataInfo top1TqData = burouter2DataService.getTop1TqData(sentence, excludeTqIds);
        logger.info("\n -> burouter2/getTop1TqData/{} \n  -->  {} ", requestBody, JSON.toJSONString(top1TqData));
        return new Result().success(top1TqData);
    }


    @PostMapping("/getTop1OrderData")
    public Result getTop1OrderData(@Auth(required = false) Long sId, @Validated @RequestBody String requestBodyJS) {
        OrderDataDto orderDataDto = JSON.parseObject(requestBodyJS, OrderDataDto.class);
        @NotBlank String sentence = orderDataDto.getSentence();
        @NotBlank String userId = orderDataDto.getUserId();
        @NotBlank String fixedTqId = orderDataDto.getFixedTqId();
        @NotBlank String excludeOrderIdsStr = orderDataDto.getExcludeOrderIds();
        Set<String> excludeOrderIds = excludeOrderIdsStr != null ? new HashSet<>(Arrays.asList(excludeOrderIdsStr.split(","))) : null;

        OrderDataInfo top1OrderData = burouter2DataService.getTop1OrderData(userId, sentence, fixedTqId, excludeOrderIds);
        logger.info("\n -> burouter2/getTop1OrderData + {} \n  -->  {} ", requestBodyJS, JSON.toJSONString(top1OrderData));
        return new Result().success(top1OrderData);
    }

    @PostMapping("/getTop2BuDatas")
    public Result getTop2BuDatas(@Auth(required = false) Long sId, @Validated @RequestBody String requestBodyJS) {
        BuDataDto buDataDto = JSON.parseObject(requestBodyJS, BuDataDto.class);
        @NotBlank String sentence = buDataDto.getSentence();
        @NotBlank String fixedTqId = buDataDto.getFixedTqId();
        @NotBlank String fixedOrderId = buDataDto.getFixedOrderId();
        @NotBlank String excludeBuIdsStr = buDataDto.getExcludeBuIds();
        Set<String> excludeBuIds = excludeBuIdsStr != null ? new HashSet<>(Arrays.asList(excludeBuIdsStr.split(","))) : null;

        List<BuDataInfo> top2BuDatas = burouter2DataService.getTop2BuDatas(sentence, fixedTqId, fixedOrderId, excludeBuIds);
        logger.info("\n -> burouter2/getTop2BuDatas + {} \n  -->  {} ", requestBodyJS, JSON.toJSONString(top2BuDatas));
        return new Result().success(top2BuDatas);
    }

    @GetMapping("/isAboutOrder/{tqId}")
    public Result isAboutOrder(@Auth(required = false) Long sId, @PathVariable("tqId") String tqId){
        Integer aboutOrder = burouter2DataService.isAboutOrder(tqId);
        logger.info("\n -> burouter2/isAboutOrder/{} \n  -->  {} ", tqId, aboutOrder + "");
        return new Result().success(aboutOrder);
    }

}
