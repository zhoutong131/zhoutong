package com.mypro.Controller;

import com.mypro.Service.GoodsService;
import com.mypro.model.Goods;
import com.mypro.util.Code;
import com.mypro.util.FileUtils;
import com.mypro.util.PageBean;
import com.mypro.util.ResultJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public String getGoodslist(@RequestBody Map data){
        Integer pageNo=Integer.parseInt(data.get("pageNo").toString());
        Integer pageSize=Integer.parseInt(data.get("pageSize").toString());
        return goodsService.getGoodsList(pageNo,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/add-goods",method = {RequestMethod.POST})
    public String addGoods(@RequestBody Goods goods){
        return goodsService.addGood(goods);
    }
}
