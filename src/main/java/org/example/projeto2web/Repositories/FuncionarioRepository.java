package org.example.projeto2web.Repositories;

import org.example.projeto2web.Models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
  }