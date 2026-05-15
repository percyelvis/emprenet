package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Producto;
import com.emprenet.emprenet.entity.ProductoDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoDTO> listar();

    Producto guardar(Producto producto);

    Producto buscarPorId(Long id);

    void eliminar(Long id);

    List<Producto> buscarPorNombre(String nombre);
}
