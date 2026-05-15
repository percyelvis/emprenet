package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Direccion;
import java.util.List;

public interface DireccionService {

    List<Direccion> listar();

    Direccion guardar(Direccion direccion);

    Direccion buscarPorId(Long id);

    Direccion actualizar(Long id, Direccion direccion);

    void eliminar(Long id);
}