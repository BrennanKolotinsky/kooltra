package com.kooltra.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello-world")
    public String index() {
        return "Hello, World!";
    }
}
