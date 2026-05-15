package com.emprenet.emprenet.repository;

import com.emprenet.emprenet.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    List<Venta> findByCompradorId(Long compradorId);

    // Buscar ventas por vendedor
    List<Venta> findByVendedorId(Long vendedorId);
}
