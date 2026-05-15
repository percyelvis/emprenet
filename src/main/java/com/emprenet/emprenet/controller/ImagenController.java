package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Imagen;
import com.emprenet.emprenet.service.ImagenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("imagenes")
public class ImagenController {

    private final ImagenService service;

    public ImagenController(ImagenService service) {
        this.service = service;
    }

    @GetMapping
    public List<Imagen> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Imagen buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Imagen guardar(@RequestBody Imagen imagen) {
        return service.guardar(imagen);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
