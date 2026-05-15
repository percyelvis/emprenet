package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Imagen;
import com.emprenet.emprenet.repository.ImagenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenServiceImpl implements ImagenService {
    private final ImagenRepository repository;

    public ImagenServiceImpl(ImagenRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Imagen> listar() {
        return repository.findAll();
    }

    @Override
    public Imagen guardar(Imagen imagen) {
        return repository.save(imagen);
    }

    @Override
    public Imagen buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
