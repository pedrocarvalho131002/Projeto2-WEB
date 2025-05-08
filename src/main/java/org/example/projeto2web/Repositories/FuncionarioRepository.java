package org.example.projeto2web.Repositories;

import org.example.projeto2web.Models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

  List<Funcionario> findByIdTipo_Id(Integer idTipo);
}
