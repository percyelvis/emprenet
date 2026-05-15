package com.emprenet.emprenet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "Index"; // ✔ correcto
    }

    @GetMapping("/register")
    public String register() {
        return "Formulario"; // ✔ si tu archivo es formulario.html
    }
}
