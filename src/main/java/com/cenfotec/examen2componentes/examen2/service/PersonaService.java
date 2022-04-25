package com.cenfotec.examen2componentes.examen2.service;

import com.cenfotec.examen2componentes.examen2.domain.Persona;
import com.cenfotec.examen2componentes.examen2.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getById(int id) {
        return  personaRepository.findById(Long.valueOf(id));
    }

    public void savePersona(Persona persona){
        personaRepository.save(persona);
    }

    public void updatePersona(Persona persona){
        personaRepository.save(persona);
    }

    public void deletePersona(int id){
        personaRepository.deleteById(Long.valueOf(id));
    }
}
