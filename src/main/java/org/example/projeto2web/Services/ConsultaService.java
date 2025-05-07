package org.example.projeto2web.Services;

import org.example.projeto2web.Models.Consulta;
import org.example.projeto2web.Repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    // Guardar ou atualizar consulta
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // Buscar por ID
    public Optional<Consulta> buscarPorId(Integer id) {
        return consultaRepository.findById(id);
    }

    // Listar todas
    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    // Listar todas com JOINs (relacionamentos)
    public List<Consulta> listarTodasComRelacionamentos() {
        return consultaRepository.findAllComRelacionamentos();
    }

    // Listar consultas de um fisioterapeuta
    public List<Consulta> listarPorFuncionario(Integer funcionarioId) {
        return consultaRepository.findAllByFuncionario(funcionarioId);
    }
}
