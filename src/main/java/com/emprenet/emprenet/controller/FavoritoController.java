package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Favorito;
import com.emprenet.emprenet.service.FavoritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    private final FavoritoService service;

    public FavoritoController(FavoritoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Favorito> listar() {
        return service.listar();
    }

    @PostMapping
    public Favorito guardar(@RequestBody Favorito favorito) {
        return service.guardar(favorito);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    // 🔥 Favoritos por usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Favorito> porUsuario(@PathVariable Long usuarioId) {
        return service.buscarPorUsuario(usuarioId);
    }
}