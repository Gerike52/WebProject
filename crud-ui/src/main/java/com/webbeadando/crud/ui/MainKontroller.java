package com.webbeadando.crud.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainKontroller {

    @GetMapping("")
    public String FoOldal(){
        return "index";
    }
}
