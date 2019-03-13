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
    @RequestMapping(value="/upload-img", method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile data,
                               HttpServletRequest request){
        String path="";
        if(!data.isEmpty()){
            try {
                path= FileUtils.uploadFile(data,"artical-img",request);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ResultJson.toJson(Code.SUCCESS,"上传成功！",path);  //上传成功
    }
}