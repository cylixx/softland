package com.actinver.eactinver.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
 
    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title", "Dear User");
        modal.addAttribute("message", "Welcome to eactinver-management");
        return "hello";
    }
}
