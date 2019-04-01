package com.mypro.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mypro.Service.GoodsService;
import com.mypro.mapper.GoodsMapper;
import com.mypro.model.Goods;
import com.mypro.util.Code;
import com.mypro.util.PageBean;
import com.mypro.util.ResultJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Override
    public String getGoodsList(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Goods> goodslist=goodsMapper.getGoodsList();
        if(goodslist!=null&&goodslist.size()>0){
            PageInfo<Goods> pageInfo= new PageInfo<Goods>(goodslist);
            return ResultJson.toJson(Code.SUCCESS,Code.FIND_SUCC_MSG,pageInfo);
        }
        return ResultJson.toJson(Code.FAILED,Code.FIND_FAIL_MSG,Code.NULL_STR);
    }

    @Override
    public String addGood(Goods good) {
        good.setStatus(Code.ONE);
        good.setUpdate_time(new Date());
        Integer res=goodsMapper.insertSelective(good);
        if(res>0)
            return ResultJson.toJson(Code.SUCCESS,Code.SAVE_SUCC_MSG,Code.NULL_STR);
        return ResultJson.toJson(Code.SUCCESS,Code.SAVE_SUCC_MSG,Code.NULL_STR);
    }
}
