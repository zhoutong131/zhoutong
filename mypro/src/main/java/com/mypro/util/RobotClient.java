package com.mypro.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: zhouhe
 * @Date: 2019/6/20 17:26
 */
public class RobotClient {


    public static String send(String webhook, TextMessage message) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(webhook);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");
        StringEntity se = new StringEntity(message.toJsonString(), "utf-8");
        httppost.setEntity(se);
        HttpResponse response = httpclient.execute(httppost);
        Integer code=0;String msg="";
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            JSONObject obj = JSONObject.parseObject(result);
            Integer errcode = obj.getInteger("errcode");
            code=errcode;msg=obj.getString("errmsg");

        }
        if(code!=null){
            return ResultJson.toJson(Code.SUCCESS,msg,Code.NULL_STR);
        }else{
            return ResultJson.toJson(Code.FAILED,"消息发送失误！",Code.NULL_STR);
        }

    }
}
