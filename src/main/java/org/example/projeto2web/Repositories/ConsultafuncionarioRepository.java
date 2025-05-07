package org.example.projeto2web.Repositories;

import org.example.projeto2web.Models.Consultafuncionario;
import org.example.projeto2web.Models.ConsultafuncionarioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultafuncionarioRepository extends JpaRepository<Consultafuncionario, ConsultafuncionarioId> {
  }