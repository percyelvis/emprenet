package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Delivery;
import com.emprenet.emprenet.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<Delivery>> listar() {
        return ResponseEntity.ok(deliveryService.listar());
    }

    @PostMapping
    public ResponseEntity<Delivery> crear(@RequestBody Delivery delivery) {
        return ResponseEntity.ok(deliveryService.guardar(delivery));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> obtener(@PathVariable Long id) {
        Delivery delivery = deliveryService.buscarPorId(id);

        if (delivery == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(delivery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delivery> actualizar(@PathVariable Long id, @RequestBody Delivery delivery) {
        Delivery actualizado = deliveryService.actualizar(id, delivery);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        deliveryService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
