package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Pago;
import com.emprenet.emprenet.entity.Usuario;
import com.emprenet.emprenet.entity.Venta;
import com.emprenet.emprenet.repository.PagoRepository;
import com.emprenet.emprenet.repository.UsuarioRepository;
import com.emprenet.emprenet.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Pago> listar() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago guardar(Pago pago) {
        pago.setFecha(LocalDateTime.now());

        if (pago.getEstado() == null) {
            pago.setEstado("PENDIENTE");
        }

        return pagoRepository.save(pago);
    }

    @Override
    public Pago buscarPorId(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @Override
    public Pago actualizar(Long id, Pago pago) {
        return pagoRepository.findById(id).map(p -> {
            p.setMonto(pago.getMonto());
            p.setMetodo(pago.getMetodo());
            p.setEstado(pago.getEstado());
            return pagoRepository.save(p);
        }).orElse(null);
    }

    public Pago confirmarPago(Long id) {

        return pagoRepository.findById(id).map(p -> {

            p.setEstado("PAGADO");
            p.setFecha(LocalDateTime.now());

            return pagoRepository.save(p);

        }).orElse(null);
    }


    @Override
    public void eliminar(Long id) {
        pagoRepository.deleteById(id);
    }

    public Pago crearDesdeCarrito(
            List<Map<String, Object>> carrito,
            Double total,
            Long compradorId
    ) {

        Usuario comprador = usuarioRepository.findById(compradorId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 🔵 VENTA
        Venta venta = new Venta();
        venta.setPrecioTotal(total);
        venta.setEstado("PENDIENTE");
        venta.setFecha(LocalDateTime.now());
        venta.setComprador(comprador);

        venta = ventaRepository.save(venta); // ⚠️ IMPORTANTE: reasignar

        // 🔵 PAGO
        Pago pago = new Pago();
        pago.setMonto(total);
        pago.setMetodo("WEB");
        pago.setEstado("PENDIENTE");
        pago.setVenta(venta);

        return pagoRepository.save(pago);
    }
}
