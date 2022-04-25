package com.cenfotec.examen2componentes.examen2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
