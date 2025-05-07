package org.example.projeto2web.Repositories;

import org.example.projeto2web.Models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}