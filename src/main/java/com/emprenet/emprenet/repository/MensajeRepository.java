package com.emprenet.emprenet.repository;

import com.emprenet.emprenet.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
    List<Mensaje> findByEmisorIdAndReceptorId(Long emisorId, Long receptorId);
}
