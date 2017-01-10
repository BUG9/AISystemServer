package com.swpu.controller;

import com.swpu.model.DataSource;
import com.swpu.model.Information;
import com.swpu.service.InformationService;

import com.swpu.socket.MessageEntity;
import com.swpu.socket.impl.SendThread;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by BUG666 on 2017/1/4.
 */
@Controller
public class InfController {
    @Resource
    private InformationService informationService;

    @RequestMapping(value = "/getInf",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public DataSource<Information> getInfApp(){
        DataSource<Information> informationDataSource = new DataSource<>();
        Information information  = informationService.findLast();
        if (information != null ) {
            informationDataSource.setMessage("获取成功!");
            informationDataSource.setDate(information);
            informationDataSource.setCode(1);
        }
        else {
            informationDataSource.setCode(0);
            informationDataSource.setMessage("获取失败！");
        }
        return informationDataSource;
    }
    @RequestMapping(value = "/getInformation",method = {RequestMethod.GET,RequestMethod.POST})
    public String  getInf(Model model){
         Information information = informationService.findLast();
         model.addAttribute("inf",information);
        return "homepage";
    }

    @RequestMapping(value = "/getInformationHtml",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Information getInformation(){
               return informationService.findLast();
    }



    @RequestMapping(value = "/control",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public DataSource<Information> control(@RequestParam String order){
        String text ;
        MessageEntity m = new MessageEntity();
        DataSource<Information> informationDataSource = new DataSource<>();
         switch (order){
             case "turnOnFan":
                   text = "open-fan";
                 m = new MessageEntity(0,text);
                 SendThread.sendMessage(m);
                 informationDataSource.setCode(1);
                 informationDataSource.setMessage("风扇开启成功");
                 break;
             case "turnDownFan":
                 text = "close-fan";
                 m = new MessageEntity(0,text);
                 SendThread.sendMessage(m);
                 informationDataSource.setCode(0);
                 informationDataSource.setMessage("风扇关闭成功");
                 break;
             case "turnOnLight":
                 text = "open-light";
                 m = new MessageEntity(0,text);
                 SendThread.sendMessage(m);
                 informationDataSource.setCode(1);
                 informationDataSource.setMessage("灯泡开启成功");
                 break;
             case "turnDownLight":
                 text = "close-light";
                 m = new MessageEntity(0,text);
                 SendThread.sendMessage(m);
                 informationDataSource.setCode(0);
                 informationDataSource.setMessage("灯泡关闭成功");
                 break;
             case "turnOnWaterPump":
                 text = "open-pump";
                 m = new MessageEntity(0,text);
                 SendThread.sendMessage(m);
                 informationDataSource.setCode(1);
                 informationDataSource.setMessage("水泵开启成功");
                 break;
             case "turnDownWaterPump":
                 text = "close-pump";
                 m = new MessageEntity(0,text);
                 SendThread.sendMessage(m);
                 informationDataSource.setCode(0);
                 informationDataSource.setMessage("水泵关闭成功");
                 break;
             default:
                 informationDataSource.setCode(2);
                 informationDataSource.setMessage("请求失败");
                 break;
         }
        return informationDataSource;
    }
    @RequestMapping(value = "/controlHtml",method = {RequestMethod.POST,RequestMethod.GET})
    public void controlHtml(@RequestParam String order){
        String text ;
        MessageEntity m = new MessageEntity();
        switch (order){
            case "turnOnFan":
                text = "open-fan";
                m = new MessageEntity(0,text);
                SendThread.sendMessage(m);
                break;
            case "turnDownFan":
                text = "close-fan";
                m = new MessageEntity(0,text);
                SendThread.sendMessage(m);
                break;
            case "turnOnLight":
                text = "open-light";
                m = new MessageEntity(0,text);
                SendThread.sendMessage(m);
                break;
            case "turnDownLight":
                text = "close-light";
                m = new MessageEntity(0,text);
                SendThread.sendMessage(m);
                break;
            case "turnOnWaterPump":
                text = "open-pump";
                m = new MessageEntity(0,text);
                SendThread.sendMessage(m);
                break;
            case "turnDownWaterPump":
                text = "close-pump";
                m = new MessageEntity(0,text);
                SendThread.sendMessage(m);
                break;
            default:
                break;
        }
    }

}
