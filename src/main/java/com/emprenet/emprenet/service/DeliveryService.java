package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Delivery;

import java.util.List;

public interface DeliveryService {

    List<Delivery> listar();

    Delivery guardar(Delivery delivery);

    Delivery buscarPorId(Long id);

    Delivery actualizar(Long id, Delivery delivery);

    void eliminar(Long id);
}