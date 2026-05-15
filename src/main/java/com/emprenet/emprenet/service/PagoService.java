package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Pago;
import java.util.List;

public interface PagoService {

    List<Pago> listar();

    Pago guardar(Pago pago);

    Pago buscarPorId(Long id);

    Pago actualizar(Long id, Pago pago);

    void eliminar(Long id);

    Pago confirmarPago(Long id);
}