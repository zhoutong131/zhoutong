package com.mypro.Controller;

import com.mypro.Service.CommentService;
import com.mypro.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/article")
public class CommentController {
    @Resource
    private CommentService commentService;


    @ResponseBody
    @RequestMapping(value = "/add-comment",method = {RequestMethod.POST})
    public String addArticle(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
}
