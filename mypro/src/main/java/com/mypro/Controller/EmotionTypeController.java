package com.mypro.Controller;

import com.mypro.Service.EmotionTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/emotion-type")
public class EmotionTypeController {
    @Resource
    private EmotionTypeService emotionTypeService;

    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public String getEmotionTypelist(){

        return emotionTypeService.getListBypage();
    }

}
