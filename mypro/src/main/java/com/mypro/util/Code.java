package com.mypro.util;

import java.math.BigDecimal;

public interface Code {
    /*平台利率*/
    BigDecimal DISCOUNT_RATE = new BigDecimal("0.005");

    /*常用状态*/
    Integer ERROR_OPERATION = 2;
    Integer SUCCESS = 1;
    Integer FAILED = 0;
    Integer OVERDUE = 1005;
    Integer ERROR = -1;
    String DELETE_TRUE = "1";
    String DELETE_FALSE = "0";

    /*鉴权失败编码*/
    Integer AUTH_ERROR_CODE = 2;
    Integer AUTH_FAIL_CODE = 1005;
    String AUth_ERROR_MSG = "鉴权失败！";
    String AUth_MSG = "用户验证失败！";
    String AUth_EXP_MSG = "Token过期！";




    /*返回信息*/
    String NULL_STR = "";
    String ERROR_MSG = "操作异常！";
    String DELETE_SUCC_MSG = "删除成功！";
    String DELETE_FAIL_MSG = "删除失败！";
    String SAVE_SUCC_MSG = "保存成功！";
    String SAVE_FAIL_MSG = "保存失败！";
    String UPDATE_SUCC_MSG = "更新成功！";
    String UPDATE_FAIL_MSG = "更新失败！";
    String FIND_SUCC_MSG = "查询成功！";
    String FIND_FAIL_MSG = "查询失败！";


    /*时间格式*/
    String YYYY_MM_DD = "yyyy-MM-dd";
    String YYYY_MM_DD_SLASH = "yyyy/MM/dd";
    String YYYY_MM_DD_HH_MM_SLASH = "yyyy/MM/dd HH:mm";
    String YYYYMMDD = "yyyyMMdd";
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    String DD_HH_MM = "HH:mm:ss";

    /*排序及分页*/
    String ASC = "ASC";
    String DESC = "DESC";
    Integer defaultPageSize = 20;


    /*字节型，数字*/
    Byte TRUE = 1;

    Byte FALSE = 0;
    Byte ZERO = 0;
    Byte ONE = 1;
    Byte TWO = 2;
    Byte THREE = 3;
    Byte FOUR = 4;
    /*整型数*/
    Integer INT_ZERO = 0;

    Integer INT_ONE = 1;
    Integer INT_TWO = 2;
    Integer INT_THREE = 3;
    String UNDER_SCORE = "_";

    Long LONG_ZERO = 0L;
    Long LONG_ONE = 1L;
    Long LONG_TWO = 2L;

    BigDecimal BD_ZERO = BigDecimal.valueOf(0);

    /*推送状态及返回信息*/
    String PUSH_FAIL = "发送失败,请稍候再试！";


    /*GPS*/
    BigDecimal DEGREES = BigDecimal.valueOf(0.0048);//500米距离的经纬度数

    /*系统*/
    String SYSTEM_BUSY = "系统繁忙";

}
