package com.mypro.model.VO;

import com.mypro.model.EmtionType;
import com.mypro.util.Code;
import com.mypro.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class EmotionTypeVO {
    private Integer id;

    private String typeName;

    private String typeDesc;

    private Integer founderId;

    private Byte auditStatus;

    private String creat_time;

    private String update_time;

    public EmotionTypeVO(EmtionType emtionType) {
        this.id = emtionType.getId();
        this.typeName = CommonUtils.getStr(emtionType.getTypeName());
        this.typeDesc = CommonUtils.getStr(emtionType.getTypeDesc());
        this.founderId = emtionType.getFounderId();
        this.auditStatus = emtionType.getAuditStatus();
        this.creat_time = CommonUtils.dateCastToString(emtionType.getCreat_time(), Code.YYYY_MM_DD);
        this.update_time = CommonUtils.dateCastToString(emtionType.getUpdate_time(), Code.YYYY_MM_DD);
    }
    public static List<EmotionTypeVO> getList(List<EmtionType> emtionTypes){
        List<EmotionTypeVO> emotionTypeVOS=new ArrayList<>();
        for(EmtionType e:emtionTypes){
            emotionTypeVOS.add(new EmotionTypeVO(e));
        }
        return  emotionTypeVOS;
    }
}
