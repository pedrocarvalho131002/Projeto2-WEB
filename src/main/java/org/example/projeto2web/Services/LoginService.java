package org.example.projeto2web.Services;

import org.example.projeto2web.Models.Funcionario;
import org.example.projeto2web.Repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Optional<LoginResult> login(Integer id, String password) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);

        if (funcionarioOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();

            if (funcionario.getPassword().equals(password)) {
                String cargo = funcionario.getIdTipo().getCargo();
                return Optional.of(new LoginResult(funcionario.getId(), password, cargo));
            }
        }

        return Optional.empty();
    }

    public static class LoginResult {
        private final Integer id;
        private final String senha;
        private final String cargo;

        public LoginResult(Integer id, String senha, String cargo) {
            this.id = id;
            this.senha = senha;
            this.cargo = cargo;
        }

        public Integer getId() {
            return id;
        }

        public String getSenha() {
            return senha;
        }

        public String getCargo() {
            return cargo;
        }
    }
}
