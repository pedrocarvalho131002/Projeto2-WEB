package org.example.projeto2web.Services;

import org.example.projeto2web.Models.TipoFuncionario;
import org.example.projeto2web.Repositories.TipoFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoFuncionarioService {

    @Autowired
    private TipoFuncionarioRepository tipoFuncionarioRepository;

    public List<TipoFuncionario> listarTodos() {
        return tipoFuncionarioRepository.findAll();
    }

    public Optional<TipoFuncionario> buscarPorId(Integer id) {
        return tipoFuncionarioRepository.findById(id);
    }
}
