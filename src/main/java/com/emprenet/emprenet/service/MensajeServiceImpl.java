package com.emprenet.emprenet.service;
import com.emprenet.emprenet.entity.Mensaje;
import com.emprenet.emprenet.repository.MensajeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MensajeServiceImpl implements MensajeService{
    private final MensajeRepository repository;
    public MensajeServiceImpl(MensajeRepository repository) {
        this.repository = repository; }

    @Override public List<Mensaje> listar() {
        return repository.findAll(); }

    @Override public Mensaje guardar(Mensaje mensaje) {
        return repository.save(mensaje); }

    @Override public List<Mensaje> listarPorConversacion(Long emisorId, Long receptorId) {
        return repository.findByEmisorIdAndReceptorId(emisorId, receptorId); }
}