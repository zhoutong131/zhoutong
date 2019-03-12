package com.mypro.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * @author 马路遥(229010812 @ qq.com)
 * @version V1.0
 * @Title: tp-workflow
 * @Package com.tekniplex.api.model.vo
 * @Description: 规范API返回样式
 * @Date 2017-12-14 11:30
 */
public class ResultJson {

    @Expose
    Integer code = Code.SUCCESS;
    @Expose
    String message = Code.NULL_STR;
    @Expose
    Object data = Code.NULL_STR;

    public Integer getCode() {
        return code==null?Code.SUCCESS:code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message==null?Code.NULL_STR:message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data==null? Code.NULL_STR:data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Json转换
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static String toJson(Integer code,String message,Object data) {
        Gson gson = new Gson();
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(code);
        resultJson.setMessage(message);
        resultJson.setData(data==null?Code.NULL_STR:data);
        return gson.toJson(resultJson);
    }

    /**
     * Json转换+注解
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static String toJsonWithExpose(Integer code,String message,Object data) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(code);
        resultJson.setMessage(message);
        resultJson.setData(data==null?Code.NULL_STR:data);
        return gson.toJson(resultJson);
    }

}
