package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Favorito;
import com.emprenet.emprenet.repository.FavoritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoServiceImpl implements FavoritoService{
    private final FavoritoRepository repository;

    public FavoritoServiceImpl(FavoritoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Favorito> listar() {
        return repository.findAll();
    }

    @Override
    public Favorito guardar(Favorito favorito) {
        return repository.save(favorito);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Favorito> buscarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}
