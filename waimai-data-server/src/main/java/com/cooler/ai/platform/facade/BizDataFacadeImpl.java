package com.cooler.ai.platform.facade;

import com.alibaba.fastjson.JSON;
import com.cooler.ai.platform.model.*;
import com.cooler.ai.platform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/9/30
 **/
@Component("bizDataFacade")
public class BizDataFacadeImpl implements BizDataFacade {
    @Resource
    private CacheService<ShoppingCartInfo> cacheService;

    @Autowired
    private PoiService poiService;

    @Autowired
    private SkuService skuService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderGroupService orderGroupService;

    @Autowired
    private OrderItemService orderItemService;

    //商品、商家服务
    @Override
    public List<PoiInfo> getPois(Map<String, String> searchParams) {

        String poiName = searchParams.get(WaimaiConstant.POI_NAME);
        String brand = searchParams.get(WaimaiConstant.BRAND);
        String currentPoiPageNum = searchParams.get(WaimaiConstant.CURRENT_POI_PAGE_NUM);
        int startId = currentPoiPageNum != null ? (Integer.parseInt(currentPoiPageNum) * WaimaiConstant.POI_COUNT_PER_PAGE) : 0;
        int count = WaimaiConstant.POI_COUNT_PER_PAGE;
        String orderBy = searchParams.get(WaimaiConstant.ORDER_BY);
        String sort = searchParams.get(WaimaiConstant.SORT);

        List<PoiInfo> poiInfos = poiService.selectPois(poiName, brand, startId, count, orderBy, sort);
        return poiInfos;
    }

    @Override
    public PoiInfo selectPoiById(Integer poiId) {
        PoiInfo poiInfo = poiService.selectPoiById(poiId);
        return poiInfo;
    }

    @Override
    public List<SkuInfo> getSkus(Map<String, String> searchParams) {
        String skuName = searchParams.get(WaimaiConstant.SKU_NAME);
        String moreThanPrice = searchParams.get(WaimaiConstant.MORE_THAN_PRICE);
        String lessThanPrice = searchParams.get(WaimaiConstant.LESS_THAN_PRICE);
        String poiId = searchParams.get(WaimaiConstant.POI_ID);
        String orderBy = searchParams.get(WaimaiConstant.ORDER_BY);
        String sort = searchParams.get(WaimaiConstant.SORT);
        String currentSkuPageNum = searchParams.get(WaimaiConstant.CURRENT_SKU_PAGE_NUM);

        List<Integer> skuIds = skuService.selectSkuIds(
                skuName,
                moreThanPrice != null ? Float.parseFloat(moreThanPrice) : null,
                lessThanPrice != null ? Float.parseFloat(lessThanPrice) : null,
                poiId != null ? Integer.parseInt(poiId) : null,
                orderBy,
                sort
        );
        int skuSize = skuIds.size();

        int startIndex = currentSkuPageNum != null ? (Integer.parseInt(currentSkuPageNum) * WaimaiConstant.SKU_COUNT_PER_PAGE) : 0;
        if(startIndex >= skuSize) return new ArrayList<>();

        int startId = skuIds.get(startIndex);
        int count = WaimaiConstant.SKU_COUNT_PER_PAGE;

        List<SkuInfo> skuInfos = skuService.selectSkus(
                skuName,
                moreThanPrice != null ? Float.parseFloat(moreThanPrice) : null,
                lessThanPrice != null ? Float.parseFloat(lessThanPrice) : null,
                poiId != null ? Integer.parseInt(poiId) : null,
                orderBy,
                sort,
                startId,
                count);

        return skuInfos;

    }

    @Override
    public List<SkuInfo> getSkusByIds(Set<Integer> skuIds) {
        List<SkuInfo> skuInfos = skuService.getSkusByIds(skuIds);
        return skuInfos;
    }

    //购物车服务
    @Override
    public ShoppingCartInfo checkShoppingCart(String userId) {
        if(userId == null) return null;
        String cacheKey = WaimaiConstant.SHOPPING_CART + "_" + userId;
        ShoppingCartInfo shoppingCartInfo = cacheService.getContext(cacheKey);
        return shoppingCartInfo;
    }

    @Override
    public void saveOrderDataToShoppingCart(OrderDataInfo orderDataInfo) {
        List<OrderItemInfo> orderItemInfos = orderDataInfo.getOrderItemInfos();
        for (OrderItemInfo orderItemInfo : orderItemInfos) {
            String userId = orderItemInfo.getUserId();
            Integer skuId = orderItemInfo.getSkuId();
            String skuName = orderItemInfo.getSkuName();
            Integer count = orderItemInfo.getCount();
            Float price = orderItemInfo.getPrice();
            Integer poiId = orderItemInfo.getPoiId();
            SkuInfo skuInfo = new SkuInfo(skuId, skuName, price, poiId, null);

            addSku(userId, skuInfo, count);
        }
    }

    public ShoppingCartInfo changeSkuToCount(String userId, SkuInfo skuInfo, int changedCount) {
        return changeSkuCount(userId, skuInfo, true, changedCount);
    }

    @Override
    public ShoppingCartInfo addSkus(String userId, List<SkuInfo> skuInfos) {
        ShoppingCartInfo shoppingCartInfo = null;
        for (SkuInfo skuInfo : skuInfos) {
            shoppingCartInfo = addSku(userId, skuInfo, 1);
        }
        return shoppingCartInfo;
    }

    @Override
    public ShoppingCartInfo addSku(String userId, SkuInfo skuInfo, int count) {
        return changeSkuCount(userId, skuInfo, false, count);
    }

    @Override
    public ShoppingCartInfo deleteSku(String userId, SkuInfo skuInfo, int count) {
        return changeSkuCount(userId, skuInfo, false, -1 * count);
    }

    @Override
    public ShoppingCartInfo clearSku(String userId, SkuInfo skuInfo) {
        return changeSkuCount(userId, skuInfo, false, Integer.MIN_VALUE);
    }

    @Override
    public int clearAll(String userId) {
        String cacheKey = WaimaiConstant.SHOPPING_CART + "_" + userId;
        cacheService.removeContext(cacheKey);
        return 0;
    }

    private ShoppingCartInfo changeSkuCount(String userId, SkuInfo skuInfo, boolean isToCount, int changedCount) {
        if(userId == null) return null;
        String cacheKey = WaimaiConstant.SHOPPING_CART + "_" + userId;
        ShoppingCartInfo shoppingCartInfo = cacheService.getContext(cacheKey);
        if(shoppingCartInfo == null){
            shoppingCartInfo = new ShoppingCartInfo();
            shoppingCartInfo.setUserId(userId);
        }
        Map<Integer, Map<Integer, SkuInfo>> selectedSkuInfos = shoppingCartInfo.getSelectedSkuInfos();
        Map<Integer, PoiInfo> relatedPoiMap = shoppingCartInfo.getRelatedPoiMap();
        SortedMap<Integer, Integer> skuCountMap = shoppingCartInfo.getSkuCountMap();
        Map<Integer, Long> timestampMap = shoppingCartInfo.getTimestampMap();

        Integer poiId = skuInfo.getPoiId();
        Integer skuId = skuInfo.getId();

        Integer oldCount = skuCountMap.get(skuId);
        oldCount = oldCount == null ? 0 : oldCount;
        int newCount = 0;
        if(isToCount){                                                          //isToCount == true，将数量变为changedCount
            newCount = changedCount;
        }else{                                                                  //isToCount == false，将数量加上changedCount
            newCount = oldCount + changedCount;
        }
        if(newCount <= 0) {
            newCount = 0;
            selectedSkuInfos.remove(poiId);
            relatedPoiMap.remove(poiId);
            skuCountMap.remove(skuId);
            timestampMap.remove(skuId);
        }else{
            Map<Integer, SkuInfo> skuInfoMap = selectedSkuInfos.get(poiId);
            if(skuInfoMap == null) skuInfoMap = new HashMap<>();
            skuInfoMap.put(skuId, skuInfo);
            selectedSkuInfos.put(poiId, skuInfoMap);

            PoiInfo poiInfo = poiService.selectPoiById(poiId);
            relatedPoiMap.put(poiId, poiInfo);

            skuCountMap.put(skuId, newCount);

            timestampMap.put(skuId, System.currentTimeMillis());
        }

        shoppingCartInfo.setSkuCountMap(skuCountMap);
        shoppingCartInfo.setSelectedSkuInfos(selectedSkuInfos);
        shoppingCartInfo.setRelatedPoiMap(relatedPoiMap);
        shoppingCartInfo.setTimestampMap(timestampMap);
        cacheService.setContext(cacheKey, shoppingCartInfo);

        return shoppingCartInfo;
    }

    //地址服务
    @Override
    public List<AddressInfo> getAddressesByUserId(String userId) {
        if(userId == null) return null;
        List<AddressInfo> addressInfos = addressService.getAddressesByUserId(userId);
        return addressInfos;
    }

    //订单服务
    @Override
    public OrderGroupInfo saveOrderGroup(OrderGroupInfo orderGroupInfo) {
        if(orderGroupInfo == null) return null;
        return orderGroupService.saveOrder(orderGroupInfo);
    }

    @Override
    public List<OrderItemInfo> saveOrderItems(List<OrderItemInfo> orderItemInfos) {
        if(orderItemInfos == null || orderItemInfos.size() == 0)    return null;
        List<OrderItemInfo> orderItemInfosOut = new ArrayList<>();
        for (OrderItemInfo orderItemInfo : orderItemInfos) {
            OrderItemInfo orderItemInfoOut = orderItemService.save(orderItemInfo);
            orderItemInfosOut.add(orderItemInfoOut);
        }
        return orderItemInfosOut;
    }

    @Override
    public List<OrderDataInfo> saveOrderDatas(List<OrderDataInfo> orderDataInfos) {
        if(orderDataInfos == null) return null;
        synchronized (orderDataInfos){
            List<OrderDataInfo> orderDataInfosOut = new ArrayList<>();
            for (OrderDataInfo orderDataInfo : orderDataInfos) {
                OrderGroupInfo orderGroupInfo = orderDataInfo.getOrderGroupInfo();
                List<OrderItemInfo> orderItemInfos = orderDataInfo.getOrderItemInfos();
                OrderGroupInfo orderGroupInfoOut = orderGroupService.saveOrder(orderGroupInfo);                     //带有Id的对象
                Integer orderId = orderGroupInfoOut.getId();
                for (OrderItemInfo orderItemInfo : orderItemInfos) {
                    orderItemInfo.setOrderId(orderId);
                }
                List<OrderItemInfo> orderItemInfosOut = saveOrderItems(orderItemInfos);         //带有Id的集合
                orderDataInfosOut.add(new OrderDataInfo(orderGroupInfoOut, orderItemInfosOut, true));
            }
            return orderDataInfosOut;
        }
    }

//    @Override
//    public List<OrderGroupInfo> getOrderGroupByUserIdState(String userId, int state) {
//        if(userId == null) return null;
//        List<OrderGroupInfo> orderGroupInfos = orderGroupService.getOrderByUserIdState(userId, state);
//        return orderGroupInfos;
//    }

    @Override
    public List<OrderItemInfo> getOrderItemInfosByOrderIds(String userId, Set<Integer> orderGroupIds) {
        if(orderGroupIds == null || orderGroupIds.size() == 0)  return new ArrayList<>();
        List<OrderItemInfo> orderItemInfos = orderItemService.getOrderItemsByUserIdOrderIds(userId, orderGroupIds);
        return orderItemInfos;
    }

    @Override
    public Map<String, String> getOrderDataByUserIdStatePageNum(String userId, int state, int currentOrderPageNum) {
        //1.校验
        if(userId == null) return null;

        //2.搜索userId的OrderGroupInfo集合（历史订单）
        List<Integer> orderGroupIds = orderGroupService.selectOrderGroupIds(userId, state);
        int orderSize = orderGroupIds != null ? orderGroupIds.size() : 0;

        int startIndex = currentOrderPageNum * WaimaiConstant.ORDER_COUNT_PRE_PAGE;
        if(startIndex >= orderSize) return null;                                                                        //没有那么多符合条件的结果展示了

        int startId = orderGroupIds.get(startIndex);
        int count = WaimaiConstant.SKU_COUNT_PER_PAGE;

        List<OrderGroupInfo> orderGroupInfosSelected = orderGroupService.selectOrderGroups(userId, state, startId, count);

        //3.搜索历史订单下的所有订单项的Id准备
        List<Integer> orderGroupIdsSelected = new ArrayList<>();
        for (OrderGroupInfo orderGroupInfo : orderGroupInfosSelected) {
            Integer orderGroupId = orderGroupInfo.getId();
            orderGroupIdsSelected.add(orderGroupId);
        }

        //4.根据上面的Id集合，搜索所有相关订单项，并对其按orderId进行分组
        List<OrderItemInfo> orderItemInfos = orderItemService.getOrderItemsByOrderIds(orderGroupIdsSelected);
        Map<Integer, List<OrderItemInfo>> orderItemInfosMap = new HashMap<>();
        for (OrderItemInfo orderItemInfo : orderItemInfos) {
            Integer orderId = orderItemInfo.getOrderId();
            List<OrderItemInfo> orderItemInfosTmp = orderItemInfosMap.get(orderId);
            if(orderItemInfosTmp == null){
                orderItemInfosTmp = new ArrayList<>();
            }
            orderItemInfosTmp.add(orderItemInfo);
            orderItemInfosMap.put(orderId, orderItemInfosTmp);
        }

        //5.按orderId组合对应的订单和订单项目集，封装orderDataInfos，并传出
        List<OrderDataInfo> orderDataInfos = new ArrayList<>();
        for (OrderGroupInfo orderGroupInfo : orderGroupInfosSelected) {
            Integer orderId = orderGroupInfo.getId();
            List<OrderItemInfo> orderItemInfosTmp = orderItemInfosMap.get(orderId);
            orderDataInfos.add(new OrderDataInfo(orderGroupInfo, orderItemInfosTmp, true));
        }
        Map<String, String> orderDataInfosMap = new HashMap<>();
        orderDataInfosMap.put(WaimaiConstant.SEARCHED_PAGE_NUM, currentOrderPageNum + "");                       //当前搜索的订单页数
        orderDataInfosMap.put(WaimaiConstant.SEARCHED_ORDER_STATE, state + "");                                  //当前搜索的订单状态
        orderDataInfosMap.put(WaimaiConstant.SEARCHED_ORDER_TOTAL_SIZE, orderSize + "");                         //所有符合搜索情况的订单的数量
        orderDataInfosMap.put(WaimaiConstant.MAX_ORDER_COUNT_PER_PAGE, count + "");                              //每一页显示的订单数量
        orderDataInfosMap.put(WaimaiConstant.ORDER_COUNT_THIS_PAGE, orderDataInfos.size() + "");                 //当前页显示的订单数量
        orderDataInfosMap.put(WaimaiConstant.ORDER_DATA_INFOS, JSON.toJSONString(orderDataInfos));                //得到的订单打包对象（orderDataInfo）集
        return orderDataInfosMap;
    }

    @Override
    public OrderDataInfo getOrderDataByUserOrderId(String userId, Integer orderGroupId) {
        if(userId == null) return null;
        OrderGroupInfo orderGroupInfo = orderGroupService.getOrderById(orderGroupId);
        if(orderGroupInfo.getUserId() != userId){
            return null;
        }
        List<OrderItemInfo> orderItemInfos = orderItemService.getOrderItemsByOrderIds(Arrays.asList(orderGroupId));
        OrderDataInfo orderDataInfo = new OrderDataInfo(orderGroupInfo, orderItemInfos, true);
        return orderDataInfo;
    }

    @Override
    public int updateOrderGroup(OrderGroupInfo orderGroupInfo) {
        if(orderGroupInfo == null) return -1;
        int id = orderGroupService.updateOrder(orderGroupInfo);
        return id;
    }

}
