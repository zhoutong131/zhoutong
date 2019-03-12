package com.mypro.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.mypro.Service.EmotionTypeService;
import com.mypro.mapper.EmtionTypeMapper;
import com.mypro.model.EmtionType;
import com.mypro.model.VO.EmotionTypeVO;
import com.mypro.util.Code;
import com.mypro.util.PageBean;
import com.mypro.util.PageBeanVO;
import com.mypro.util.ResultJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("emotionTypeService")
public class EmotionTypeServiceImpl implements EmotionTypeService {
    @Resource
    private EmtionTypeMapper emtionTypeMapper;

    @Override
    public String getListBypage() {
        List<EmtionType> emtionTypes=emtionTypeMapper.getListByPage();

        if(emtionTypes!=null&&emtionTypes.size()>0){
            return ResultJson.toJson(Code.SUCCESS,Code.FIND_SUCC_MSG,EmotionTypeVO.getList(emtionTypes));
        }
        return ResultJson.toJson(Code.FAILED,Code.FIND_FAIL_MSG,Code.NULL_STR);
    }
}
