package com.emprenet.emprenet.controller;

import com.emprenet.emprenet.entity.Pago;
import com.emprenet.emprenet.entity.Usuario;
import com.emprenet.emprenet.service.EmailService;
import com.emprenet.emprenet.service.PagoService;
import com.emprenet.emprenet.service.PagoServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PagoServiceImpl pagoServiceImpl;

    @GetMapping
    public ResponseEntity<List<Pago>> listar() {
        return ResponseEntity.ok(pagoService.listar());
    }

    @PostMapping
    public ResponseEntity<Pago> crear(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.guardar(pago));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtener(@PathVariable Long id) {
        Pago p = pagoService.buscarPorId(id);
        return (p != null) ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Long id, @RequestBody Pago pago) {
        Pago p = pagoService.actualizar(id, pago);
        return (p != null) ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/confirmar/{id}")
    public ResponseEntity<Pago> confirmar(@PathVariable Long id) {

        Pago pago = pagoService.confirmarPago(id);

        if (pago == null) {
            return ResponseEntity.notFound().build();
        }

        // 🔥 CAMBIAR ESTADO
        pago.setEstado("PAGADO");
        pago.getVenta().setEstado("PAGADO");

        pagoService.guardar(pago);

        // 📩 ENVIAR CORREO
        emailService.enviarConfirmacionPago(
                pago.getVenta().getComprador().getEmail(),
                pago.getVenta().getComprador().getNombre(),
                pago.getMonto()
        );

        return ResponseEntity.ok(pago);
    }


    @PostMapping("/crear-con-venta")
    public ResponseEntity<Pago> crearPago(@RequestBody Map<String, Object> data,
                                          HttpSession session) {

        Usuario comprador = (Usuario) session.getAttribute("usuario");

        if (comprador == null) {
            return ResponseEntity.status(401).build();
        }

        List<Map<String, Object>> carrito =
                (List<Map<String, Object>>) data.get("carrito");

        Double total = Double.valueOf(data.get("total").toString());

        Pago pago = pagoServiceImpl.crearDesdeCarrito(
                carrito,
                total,
                comprador.getId()
        );

        return ResponseEntity.ok(pago);
    }
}