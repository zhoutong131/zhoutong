package com.mypro.Controller;

import com.mypro.Service.ArticleService;
import com.mypro.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping(value = "/add-article",method = {RequestMethod.POST})
    public String addArticle(@RequestBody Article article){
        return articleService.addActicle(article);
    }
}
