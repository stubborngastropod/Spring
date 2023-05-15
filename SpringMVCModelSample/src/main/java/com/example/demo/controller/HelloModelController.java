package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloModelController {
    @GetMapping("model")
    public String helloView(Model model) {
        model.addAttribute("msg", "Thymeleaf!!!");

        return "helloThymeleaf";
    }
}
