package org.example.projeto2web.Repositories;

import org.example.projeto2web.Models.Pacientelesao;
import org.example.projeto2web.Models.PacientelesaoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientelesaoRepository extends JpaRepository<Pacientelesao, PacientelesaoId> {
  }