package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> listar();

    Categoria guardar(Categoria categoria);

    Categoria buscarPorId(Long id);

    void eliminar(Long id);
}
