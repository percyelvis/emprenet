package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Usuario;
import com.emprenet.emprenet.repository.UsuarioRepository;
import com.emprenet.emprenet.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email,
                                @RequestParam String password,
                                HttpSession session){

        Usuario usuario = usuarioService.buscarPorEmail(email);

        if(usuario != null && usuario.getPassword().equals(password)){
            session.setAttribute("usuario", usuario);
            return "redirect:/dashboard"; // ✅ BIEN
        }

        return "redirect:/login?error=true";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session){
        if(session.getAttribute("usuario") == null){
            return "redirect:/login";
        }
        return "Productos/marketplace"; // tu HTML
    }

    @GetMapping("/api/usuario/me")
    public ResponseEntity<Usuario> getUsuarioActual(HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(usuario);
    }
}