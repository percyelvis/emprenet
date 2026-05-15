package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Venta;
import com.emprenet.emprenet.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService{
    private final VentaRepository repository;

    public VentaServiceImpl(VentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Venta> listar() {
        return repository.findAll();
    }

    @Override
    public Venta guardar(Venta venta) {
        return repository.save(venta);
    }

    @Override
    public Venta buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Venta> buscarPorComprador(Long compradorId) {
        return repository.findByCompradorId(compradorId);
    }

    @Override
    public List<Venta> buscarPorVendedor(Long vendedorId) {
        return repository.findByVendedorId(vendedorId);
    }

}
