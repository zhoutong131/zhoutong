package com.mypro.Controller;

import com.mypro.Service.ArticleService;
import com.mypro.model.Article;
import com.mypro.util.Code;
import com.mypro.util.FileUtils;
import com.mypro.util.ResultJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping(value = "/five-article",method = {RequestMethod.GET})
    public String getArticalList(){
        return articleService.getArticals();
    }

    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public String getArticlelist(@RequestBody Map data){

        return articleService.getArticalList(data);
    }

    @ResponseBody
    @RequestMapping(value = "/article-detail",method = {RequestMethod.GET})
    public String getArticle(@RequestParam(required = true) Integer articalId){
        return articleService.getarticleById(articalId);
    }

    @ResponseBody
    @RequestMapping(value="/upload-img", method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file,
                               HttpServletRequest request){
        String path="";
        if(!file.isEmpty()){
            try {
                path= FileUtils.uploadFile(file,"artical-img",request);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultJson.toJson(Code.SUCCESS,"上传成功！",path);  //上传成功
    }
}
