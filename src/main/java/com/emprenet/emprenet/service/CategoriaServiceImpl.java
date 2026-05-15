package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Categoria;
import com.emprenet.emprenet.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
