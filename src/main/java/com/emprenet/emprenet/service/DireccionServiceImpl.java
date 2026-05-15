package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Direccion;
import com.emprenet.emprenet.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public List<Direccion> listar() {
        return direccionRepository.findAll();
    }

    @Override
    public Direccion guardar(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public Direccion buscarPorId(Long id) {
        return direccionRepository.findById(id).orElse(null);
    }

    @Override
    public Direccion actualizar(Long id, Direccion direccion) {
        return direccionRepository.findById(id).map(d -> {
            d.setDireccion(direccion.getDireccion());
            d.setCiudad(direccion.getCiudad());
            d.setReferencia(direccion.getReferencia());
            return direccionRepository.save(d);
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        direccionRepository.deleteById(id);
    }
}