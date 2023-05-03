package com.cooler.ai.burouter;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/11/28
 **/

public class WaimaiConstant {

    public static final String POI_NAME = "poi_name";

    public static final String BRAND = "brand";

    public static final String CURRENT_POI_PAGE_NUM = "current_poi_page_num";

    public static final int POI_COUNT_PER_PAGE = 3;

    public static final String ORDER_BY = "order_by";

    public static final String SORT = "sort";


    public static final String SKU_NAME = "sku_name";

    public static final String MORE_THAN_PRICE = "more_than_price";

    public static final String LESS_THAN_PRICE = "less_than_price";

    public static final String POI_ID = "poi_id";

    public static final int SKU_COUNT_PER_PAGE = 5;

    public static final String CURRENT_SKU_PAGE_NUM = "current_sku_page_num";



    public static final String SHOPPING_CART = "shopping_cart";

    public static final int ORDER_COUNT_PRE_PAGE = 5;

    //订单状态
    public static final int ALL = -1;                               //   -1：全量
    public static final int NO_PAY = 0;                             //    0：新建，未支付；
    public static final int HAD_PAY = 1;                            //    1：已支付；
    public static final int WANT_CHANGE = 2;                        //    2：客户预换货；
    public static final int WANT_SALES_RETURN = 3;                  //    3：客户预退款；
    public static final int HAD_CHANGED = 4;                        //    4：已换货；
    public static final int HAD_SALES_RETURN = 5;                   //    5：已退货；
    public static final int IS_OVER = 6;                            //    6：已结束（过了换退期限）；


    public static final String SEARCHED_PAGE_NUM = "searched_page_num";                     //当前搜索的订单页数
    public static final String SEARCHED_ORDER_STATE = "searched_order_state";               //当前搜索的订单状态
    public static final String SEARCHED_ORDER_TOTAL_SIZE = "searched_order_total_size";     //所有符合搜索情况的订单的数量
    public static final String MAX_ORDER_COUNT_PER_PAGE = "max_order_count_per_page";       //每一页显示的订单数量
    public static final String ORDER_COUNT_THIS_PAGE = "order_count_this_page";             //当前页显示的订单数量
    public static final String ORDER_DATA_INFOS = "order_data_infos";                       //得到的订单打包对象（orderDataInfo）集

}
