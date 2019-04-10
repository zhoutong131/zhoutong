package com.mypro.Service.Impl;


import com.mypro.Service.CommentService;
import com.mypro.mapper.CommentMapper;
import com.mypro.model.Comment;
import com.mypro.util.Code;
import com.mypro.util.ResultJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public String addComment(Comment comment) {
        comment.setUpdate_time(new Date());
        comment.setStatus(Code.ONE);
        Integer res=commentMapper.insertSelective(comment);
        if(res>0)
            return ResultJson.toJson(Code.SUCCESS,Code.SAVE_SUCC_MSG,Code.NULL_STR);
        return ResultJson.toJson(Code.FAILED,Code.SAVE_FAIL_MSG,Code.NULL_STR);
    }
}
