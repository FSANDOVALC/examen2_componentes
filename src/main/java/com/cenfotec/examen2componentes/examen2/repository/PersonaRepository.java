package com.cenfotec.examen2componentes.examen2.repository;

import com.cenfotec.examen2componentes.examen2.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
