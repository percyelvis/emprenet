package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Mensaje;
import com.emprenet.emprenet.service.MensajeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    private final MensajeService service;

    public MensajeController(MensajeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mensaje> listar() {
        return service.listar();
    }

    @PostMapping
    public Mensaje guardar(@RequestBody Mensaje mensaje) {
        return service.guardar(mensaje);
    }

    @GetMapping("/conversacion")
    public List<Mensaje> conversacion(
            @RequestParam Long usuario1,
            @RequestParam Long usuario2) {

        return service.listarPorConversacion(usuario1, usuario2);
    }
}