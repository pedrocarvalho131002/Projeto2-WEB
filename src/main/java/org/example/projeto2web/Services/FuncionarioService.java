package org.example.projeto2web.Services;

import org.example.projeto2web.Models.Funcionario;
import org.example.projeto2web.Repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public List<Funcionario> listarFisioterapeutas() {
        return repository.findByIdTipo_Id(1); // 1 = Fisioterapeuta
    }

    public Optional<Funcionario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
