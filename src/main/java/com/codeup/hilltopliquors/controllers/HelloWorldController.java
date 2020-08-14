package com.codeup.hilltopliquors.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @GetMapping("/helloworld")
    @ResponseBody
    public String hello() {
        return "HELLO WORLD! 8/14/20";
    }
}
