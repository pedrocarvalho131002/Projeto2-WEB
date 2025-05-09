package org.example.projeto2web.Services;

import org.example.projeto2web.Models.TipoPagamento;
import org.example.projeto2web.Repositories.TipoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagamentoService {

    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    public List<TipoPagamento> listarTodos() {
        return tipoPagamentoRepository.findAll();
    }

    public TipoPagamento buscarPorId(Integer id) {
        return tipoPagamentoRepository.findById(id).orElse(null);
    }
}
