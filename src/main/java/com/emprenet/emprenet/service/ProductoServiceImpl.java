package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Producto;
import com.emprenet.emprenet.entity.ProductoDTO;
import com.emprenet.emprenet.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductoDTO> listar() {

        return repository.findAll().stream().map(p -> {

            ProductoDTO dto = new ProductoDTO();

            dto.setId(p.getId());
            dto.setNombre(p.getNombre());
            dto.setDescripcion(p.getDescripcion());
            dto.setPrecio(p.getPrecio());
            dto.setEstado(p.getEstado());

            // 🖼 imagen principal
            if (p.getImagenes() != null && !p.getImagenes().isEmpty()) {
                dto.setImagen(p.getImagenes().get(0).getRuta());
            }

            // 🏷 categoría
            if (p.getCategoria() != null) {
                dto.setCategoria(p.getCategoria().getNombre());
            }

            // 👤 usuario
            if (p.getUsuario() != null) {
                dto.setUsuario(p.getUsuario().getNombre());
            }

            return dto;
        }).toList();
    }



    @Override
    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }
}