package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();

    Usuario guardar(Usuario usuario);

    Usuario buscarPorId(Long id);

    void eliminar(Long id);

    Usuario buscarPorEmail(String email);
}
