package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Usuario;
import com.emprenet.emprenet.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    private final UsuarioService usuarioService;

    public PerfilController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {


        Usuario usuario = usuarioService.buscarPorId(1L);

        model.addAttribute("usuario", usuario);

        return "Productos/perfil";
    }

}