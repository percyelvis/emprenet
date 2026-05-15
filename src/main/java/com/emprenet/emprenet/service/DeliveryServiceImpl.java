package com.emprenet.emprenet.service;

import com.emprenet.emprenet.entity.Delivery;
import com.emprenet.emprenet.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> listar() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery guardar(Delivery delivery) {

        delivery.setFechaEnvio(LocalDateTime.now());

        if (delivery.getEstado() == null || delivery.getEstado().isEmpty()) {
            delivery.setEstado("PENDIENTE");
        }

        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery buscarPorId(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public Delivery actualizar(Long id, Delivery delivery) {

        return deliveryRepository.findById(id).map(d -> {

            d.setEstado(delivery.getEstado());
            d.setDireccionEntrega(delivery.getDireccionEntrega());

            // Solo actualiza fecha si se envía
            if (delivery.getFechaEntrega() != null) {
                d.setFechaEntrega(delivery.getFechaEntrega());
            }

            return deliveryRepository.save(d);

        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        deliveryRepository.deleteById(id);
    }
}