package org.example.projeto2web.Controllers;

import org.example.projeto2web.Models.Funcionario;
import org.example.projeto2web.Services.LoginService;
import org.example.projeto2web.Services.LoginService.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    public static Integer fisioterapeutaLogadoId = null;

    @Autowired
    private LoginService loginService;

    // Ao abrir localhost:8080, redireciona para /login
    @GetMapping("/")
    public String redirecionarParaLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginData", new Funcionario());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginData") Funcionario loginData, Model model) {
        String idInput = loginData.getId() != null ? loginData.getId().toString() : "";
        String senha = loginData.getPassword();

        if (idInput.isBlank() || senha == null || senha.isBlank()) {
            model.addAttribute("loginError", "Preencha todos os campos.");
            return "login";
        }

        Integer funcionarioId;
        try {
            funcionarioId = Integer.parseInt(idInput);
        } catch (NumberFormatException e) {
            model.addAttribute("loginError", "ID deve ser numérico.");
            return "login";
        }

        Optional<LoginResult> loginResultOpt = loginService.login(funcionarioId, senha);

        if (loginResultOpt.isPresent()) {
            LoginResult loginResult = loginResultOpt.get();
            String cargo = loginResult.getCargo().toLowerCase();

            if ("fisioterapeuta".equals(cargo)) {
                fisioterapeutaLogadoId = loginResult.getId();
                return "redirect:/fisioterapeuta/home";
            } else if ("admin".equals(cargo)) {
                return "redirect:/admin/home";
            } else if ("rececionista".equals(cargo)) {
                return "redirect:/rececionista/home";
            } else {
                return "redirect:/home";
            }
        } else {
            model.addAttribute("loginError", "Credenciais inválidas.");
            return "login";
        }
    }
}
