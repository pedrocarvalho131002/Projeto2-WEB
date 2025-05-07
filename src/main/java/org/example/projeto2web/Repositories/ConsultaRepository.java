package org.example.projeto2web.Repositories;

import org.example.projeto2web.Models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

  // Lista todas as consultas com as relações carregadas
  @Query("SELECT c FROM Consulta c " +
          "LEFT JOIN FETCH c.idPaciente " +
          "LEFT JOIN FETCH c.idTipo " +
          "LEFT JOIN FETCH c.idFuncionario")
  List<Consulta> findAllComRelacionamentos();

  // Lista apenas as consultas de um fisioterapeuta específico
  @Query("SELECT c FROM Consulta c " +
          "LEFT JOIN FETCH c.idPaciente " +
          "LEFT JOIN FETCH c.idTipo " +
          "WHERE c.idFuncionario.id = :funcId")
  List<Consulta> findAllByFuncionario(@Param("funcId") Integer funcId);
}
