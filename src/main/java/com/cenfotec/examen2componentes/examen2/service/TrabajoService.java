package com.cenfotec.examen2componentes.examen2.service;

import com.cenfotec.examen2componentes.examen2.domain.Trabajo;
import com.cenfotec.examen2componentes.examen2.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajoService {

    @Autowired
    TrabajoRepository trabajoRepository;

    public List<Trabajo> getAll() {
        return trabajoRepository.findAll();
    }

    public Optional<Trabajo> getById(int id) {
        return  trabajoRepository.findById(Long.valueOf(id));
    }

    public void saveTrabajo(Trabajo trabajo){
        trabajoRepository.save(trabajo);
    }

    public void updateTrabajo(Trabajo trabajo){
        trabajoRepository.save(trabajo);
    }

    public void deleteTrabajo(int id){
        trabajoRepository.deleteById(Long.valueOf(id));
    }

}
