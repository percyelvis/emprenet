package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Usuario;
import com.emprenet.emprenet.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    private final UsuarioService service;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return service.guardar(usuario);
    }

    @GetMapping("/me")
    public Usuario obtenerUsuarioLogueado(HttpSession session) {

        Long id = (Long) session.getAttribute("usuarioId");

        if (id == null) {
            return null;
        }

        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
