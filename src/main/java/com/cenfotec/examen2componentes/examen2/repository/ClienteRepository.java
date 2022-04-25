package com.cenfotec.examen2componentes.examen2.repository;

import com.cenfotec.examen2componentes.examen2.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
