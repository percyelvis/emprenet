package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Direccion;
import com.emprenet.emprenet.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<Direccion>> listar() {
        return ResponseEntity.ok(direccionService.listar());
    }

    @PostMapping
    public ResponseEntity<Direccion> crear(@RequestBody Direccion direccion) {
        return ResponseEntity.ok(direccionService.guardar(direccion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> obtener(@PathVariable Long id) {
        Direccion d = direccionService.buscarPorId(id);
        return (d != null) ? ResponseEntity.ok(d) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> actualizar(@PathVariable Long id, @RequestBody Direccion direccion) {
        Direccion d = direccionService.actualizar(id, direccion);
        return (d != null) ? ResponseEntity.ok(d) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        direccionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}