package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Imagen;

import java.util.List;

public interface ImagenService {
    List<Imagen> listar();

    Imagen guardar(Imagen imagen);

    Imagen buscarPorId(Long id);

    void eliminar(Long id);
}
