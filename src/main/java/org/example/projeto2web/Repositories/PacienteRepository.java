package org.example.projeto2web.Repositories;

import org.example.projeto2web.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
  }