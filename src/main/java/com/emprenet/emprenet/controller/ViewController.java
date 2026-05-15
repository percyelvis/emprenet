package com.emprenet.emprenet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "index"; // index.html
    }

    @GetMapping("/register")
    public String register() {
        return "Formulario"; // register.html
    }

}
