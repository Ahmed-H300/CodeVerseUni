package com.codeverse.code_verse_uni.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class AppController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

}
