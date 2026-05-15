package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Pago;
import com.emprenet.emprenet.entity.Venta;
import com.emprenet.emprenet.service.PagoServiceImpl;
import com.emprenet.emprenet.service.VentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ventas")
public class VentaController {
    private final VentaService service;
    private final PagoServiceImpl pagoServiceImpl;

    public VentaController(VentaService service, PagoServiceImpl pagoServiceImpl) {
        this.service = service;
        this.pagoServiceImpl = pagoServiceImpl;
    }

    @GetMapping
    public List<Venta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Venta buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return service.guardar(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/comprador/{id}")
    public List<Venta> porComprador(@PathVariable Long id) {
        return service.buscarPorComprador(id);
    }

    @GetMapping("/vendedor/{id}")
    public List<Venta> porVendedor(@PathVariable Long id) {
        return service.buscarPorVendedor(id);
    }

}
