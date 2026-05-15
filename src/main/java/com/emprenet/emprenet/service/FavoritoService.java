package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Favorito;

import java.util.List;

public interface FavoritoService {
    List<Favorito> listar();

    Favorito guardar(Favorito favorito);

    void eliminar(Long id);

    List<Favorito> buscarPorUsuario(Long usuarioId);
}
