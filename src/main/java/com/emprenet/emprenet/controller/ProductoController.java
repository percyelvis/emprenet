package com.emprenet.emprenet.controller;


import com.emprenet.emprenet.entity.Producto;
import com.emprenet.emprenet.entity.ProductoDTO;
import com.emprenet.emprenet.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // 🔥 LISTAR PRODUCTOS (DTO para frontend)
    @GetMapping
    public List<ProductoDTO> listar() {
        return service.listar();
    }

    // 🔍 BUSCAR POR ID (ENTITY o DTO si quieres, aquí dejamos ENTITY simple)
    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // ➕ CREAR PRODUCTO
    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        if (producto.getImagenes() != null) {
            producto.getImagenes().forEach(img -> {
                img.setProducto(producto); // 🔥 CLAVE
            });
        }

        return service.guardar(producto);
    }

    // ✏️ ACTUALIZAR PRODUCTO
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return service.guardar(producto);
    }

    // 🗑 ELIMINAR PRODUCTO
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}