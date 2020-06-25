package com.cooler.ai.platform.facade;

import com.cooler.ai.platform.model.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangsheng on 2019/9/30.
 */
public interface BizDataFacade {

    //针对商品、商家的查询服务
    List<SkuInfo> getSkus(Map<String, String> skuParams);

    List<SkuInfo> getSkusByIds(Set<Integer> skuIds);

    List<PoiInfo> getPois(Map<String, String> poiParams);

    PoiInfo selectPoiById(Integer poiId);

    //针对购物车的增删改查的服务
    ShoppingCartInfo checkShoppingCart(String userId);

    void saveOrderDataToShoppingCart(OrderDataInfo orderDataInfo);

    ShoppingCartInfo changeSkuToCount(String userId, SkuInfo skuInfo, int changedCount);

    ShoppingCartInfo addSkus(String userId, List<SkuInfo> skuInfos);

    ShoppingCartInfo addSku(String userId, SkuInfo skuInfo, int count);

    ShoppingCartInfo deleteSku(String userId, SkuInfo skuInfo, int count);

    ShoppingCartInfo clearSku(String userId, SkuInfo skuInfo);

    int clearAll(String userId);

    //针对用户地址的服务
    List<AddressInfo> getAddressesByUserId(String userId);


    //针对用户订单的服务
    List<OrderDataInfo> saveOrderDatas(List<OrderDataInfo> orderDataInfos);                         //保存打包的OrderDataInfo集合，返回带有Id的此集合

    OrderGroupInfo saveOrderGroup(OrderGroupInfo orderGroupInfo);                                        //保存OrderGroupInfo对象，返回带Id的此对象

    List<OrderItemInfo> saveOrderItems(List<OrderItemInfo> orderItemInfos);                         //保存OrderItemInfo集合，返回带Id的此集合



    OrderDataInfo getOrderDataByUserOrderId(String userId, Integer orderGroupId);                            //通过userId和orderId获取已经打包好的OrderDataInfo

    Map<String, String> getOrderDataByUserIdStatePageNum(String userId, int state, int currentOrderPageNum);           //通过userId和订单State和当前页面currentOrderPageNum，获取当前页的所涉及的数据（详见此实现方法）



//    List<OrderGroupInfo> getOrderGroupByUserIdState(String userId, int state);                           //通过userId和state，查询此用户的所有在state状态下的OrderGroupInfo

    int updateOrderGroup(OrderGroupInfo orderGroupInfo);                                                 //修改OrderGroupInfo对象，返回修改结果（-1表示失败）

    List<OrderItemInfo> getOrderItemInfosByOrderIds(String userId, Set<Integer> orderGroupIds);     //通过userId和orderGroupIds获取所有涉及的OrderItemInfo集合（此方式只能在外部进行打包为OrderDataInfo了）


}
