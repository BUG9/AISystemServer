package com.swpu;


import com.swpu.service.InformationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


/**
 * Created by wang0 on 2016/11/16.
 */
@Controller
@SpringBootApplication
@ServletComponentScan
public class Springboot {
    @Resource
    protected InformationService informationService;
    public static void main(String[] args) {
        SpringApplication.run(Springboot.class, args);
    }
}
