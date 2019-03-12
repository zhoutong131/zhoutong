package com.mypro.Service.Impl;

import com.mypro.Service.ArticleService;
import com.mypro.mapper.ArticleMapper;
import com.mypro.model.Article;
import com.mypro.util.Code;
import com.mypro.util.ResultJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public String addActicle(Article article) {
        article.setStatus(Code.ONE);
        article.setPublish_time(new Date());
        article.setUpdate_time(new Date());
        Integer res=articleMapper.insertSelective(article);
        if(res>0)
        {
            return ResultJson.toJson(Code.SUCCESS,Code.SAVE_SUCC_MSG,Code.NULL_STR);
        }
        return ResultJson.toJson(Code.FAILED,Code.SAVE_FAIL_MSG,Code.NULL_STR);
    }
}
