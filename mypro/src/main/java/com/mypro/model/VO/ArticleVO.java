package com.mypro.model.VO;

import com.mypro.model.Article;
import com.mypro.util.Code;
import com.mypro.util.CommonUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleVO {
    private Integer id;

    private String article_name;

    private String article_img;

    private Integer comment_id;

    private Integer comment_num;

    private Integer brow_num;

    private Integer author_id;

    private String author_name;

    private Byte status;

    private String publish_time;

    private String create_time;

    private String update_time;

    private String article_content;

    public ArticleVO(Article article) {
        this.id = article.getId();
        this.article_name = CommonUtils.getStr(article.getArticle_name());
        this.article_img = CommonUtils.getStr(article.getArticle_img());
        this.comment_id = article.getComment_id();
        this.comment_num = article.getComment_num();
        this.brow_num = article.getBrow_num();
        this.author_id = article.getAuthor_id();
        this.author_name = CommonUtils.getStr(article.getAuthor_name());
        this.status = article.getStatus();
        this.publish_time = CommonUtils.dateCastToString(article.getPublish_time(), Code.YYYY_MM_DD);
        this.create_time = CommonUtils.dateCastToString(article.getCreate_time(), Code.YYYY_MM_DD);
        this.update_time = CommonUtils.dateCastToString(article.getUpdate_time(), Code.YYYY_MM_DD);
        this.article_content = CommonUtils.getStr(article.getArticle_content());
    }
    public static List<ArticleVO> getList(List<Article> articles){
        List<ArticleVO> articleVOS=new ArrayList<>();
        for(Article a:articles){
            articleVOS.add(new ArticleVO(a));
        }
        return  articleVOS;
    }
}