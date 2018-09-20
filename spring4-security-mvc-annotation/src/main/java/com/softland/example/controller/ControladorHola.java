package com.softland.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class ControladorHola {
 
    @RequestMapping("/hola")
    public String hola(ModelMap model) {
 
        model.addAttribute("mensaje", "hola desde spring mvc");
        return "hola";
 
    }
     
    @RequestMapping("/adios")
    public String adios(ModelMap model) {
 
        model.addAttribute("mensaje", "adios desde spring mvc");
        return "adios";
 
    }
     
     
 
}