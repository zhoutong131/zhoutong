package com.mypro.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mypro.Service.ArticleService;
import com.mypro.mapper.ArticleMapper;
import com.mypro.model.Article;
import com.mypro.model.VO.ArticleVO;
import com.mypro.util.Code;
import com.mypro.util.ResultJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public String addActicle(Article article) {
        article.setStatus(Code.ONE);
        article.setBrow_num(0);
        article.setPublish_time(new Date());
        article.setUpdate_time(new Date());
        if(article.getArticle_img()==null||article.getArticle_img().length()<=0){
            article.setArticle_img("1");
        }
        Integer res=articleMapper.insertSelective(article);
        if(res>0)
        {
            return ResultJson.toJson(Code.SUCCESS,Code.SAVE_SUCC_MSG,Code.NULL_STR);
        }
        return ResultJson.toJson(Code.FAILED,Code.SAVE_FAIL_MSG,Code.NULL_STR);
    }

    @Override
    public String getArticals() {
        List<Article> articles=articleMapper.getfiveList();
        if(articles!=null&&articles.size()>0){
            return ResultJson.toJson(Code.SUCCESS,Code.FIND_SUCC_MSG,ArticleVO.getList(articles));
        }
        else
            return ResultJson.toJson(Code.FAILED,Code.FIND_FAIL_MSG,Code.NULL_STR);
    }


    @Override
    public String getArticalList(Map data) {
        Integer pageNo=Integer.parseInt(data.get("pageNo").toString()),
                pageSize=Integer.parseInt(data.get("pageSize").toString());
        String keyWord="";
        if(data.get("keyword")!=null)
            keyWord=data.get("keyword").toString();
        PageHelper.startPage(pageNo,pageSize);
        List<Article> articles=articleMapper.getArticallist(keyWord);
        if(articles!=null&&articles.size()>0){
            PageInfo<ArticleVO> pageInfo= new PageInfo<ArticleVO>(ArticleVO.getList(articles));
            return ResultJson.toJson(Code.SUCCESS,Code.FIND_SUCC_MSG,pageInfo);
        }
        return ResultJson.toJson(Code.FAILED,Code.FIND_FAIL_MSG,Code.NULL_STR);
    }

    @Override
    public String getarticleById(Integer aid) {
        Article article=articleMapper.getDetailById(aid);
        if(article!=null){
            return ResultJson.toJson(Code.SUCCESS,Code.FIND_SUCC_MSG,new ArticleVO(article));
        }
        return ResultJson.toJson(Code.FAILED,Code.FIND_FAIL_MSG,Code.NULL_STR);
    }
}
