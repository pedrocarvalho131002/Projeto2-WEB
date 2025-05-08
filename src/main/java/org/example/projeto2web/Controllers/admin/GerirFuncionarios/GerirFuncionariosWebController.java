package org.example.projeto2web.Controllers.admin.GerirFuncionarios;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/gerirfuncionarios")
public class GerirFuncionariosWebController {

    @GetMapping
    public String homeGerirFuncionarios() {
        return "admin/gerirfuncionarios/home-funcionarios";
    }
}
