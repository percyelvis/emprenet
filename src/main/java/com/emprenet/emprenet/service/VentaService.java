package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Venta;

import java.util.List;

public interface VentaService {
    List<Venta> listar();

    Venta guardar(Venta venta);

    Venta buscarPorId(Long id);

    void eliminar(Long id);

    List<Venta> buscarPorComprador(Long compradorId);

    List<Venta> buscarPorVendedor(Long vendedorId);
}
