package org.example.projeto2web.Services;

import org.example.projeto2web.Models.TipoConsulta;
import org.example.projeto2web.Repositories.TipoConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoConsultaService {

    @Autowired
    private TipoConsultaRepository tipoConsultaRepository;

    public List<TipoConsulta> listarTodos() {
        return tipoConsultaRepository.findAll();
    }
}
