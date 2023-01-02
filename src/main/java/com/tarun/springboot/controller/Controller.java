package com.tarun.springboot.controller;

import com.tarun.springboot.service.SpringbootService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    SpringbootService springbootService;

    @GetMapping("/search")
   public String webSearch(){
        return springbootService.webSearch();
    }

}
