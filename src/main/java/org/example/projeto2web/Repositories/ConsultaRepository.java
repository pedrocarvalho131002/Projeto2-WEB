package org.example.projeto2web.Repositories;

import org.example.projeto2web.Models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
  }