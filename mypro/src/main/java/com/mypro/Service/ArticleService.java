package com.mypro.Service;

import com.mypro.model.Article;

import java.util.Map;

public interface ArticleService {

    String addActicle(Article article);

    String getArticals();

    String getarticleById(Integer aid);

    String getArticalList(Map data);
}
