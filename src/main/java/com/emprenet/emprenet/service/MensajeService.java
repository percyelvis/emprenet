package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Mensaje;

import java.util.List;

public interface MensajeService {
    List<Mensaje> listar();

    Mensaje guardar(Mensaje mensaje);

    List<Mensaje> listarPorConversacion(Long emisorId, Long receptorId);
}
