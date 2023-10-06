package com.suprememedia.funda.auth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {


    @GetMapping("/signup")
    public  String signUpUser(){
        return  "open URL no authentication here ";
    }
    @GetMapping("/admin")
    public  String adminUpUser(){
        return  "welcome to secure url ";
    }
}
