package com.tarun.springboot.controller;

import com.tarun.springboot.model.SearchResp;
import com.tarun.springboot.service.SpringbootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class Controller {

    @Autowired
    SpringbootService springbootService;

    @GetMapping("/")
    public String home(){
        log.info("home page");
        return "welcome";
    }

    @GetMapping("/search")
   public SearchResp webSearch(){
        return springbootService.webSearch();
    }

}
