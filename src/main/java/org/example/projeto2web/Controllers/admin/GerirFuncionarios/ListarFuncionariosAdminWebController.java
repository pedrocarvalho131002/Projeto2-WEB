package org.example.projeto2web.Controllers.admin.GerirFuncionarios;

import org.example.projeto2web.Models.Funcionario;
import org.example.projeto2web.Services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/GerirFuncionarios")
public class ListarFuncionariosAdminWebController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioService.listarTodos();
        model.addAttribute("funcionarios", funcionarios);
        return "admin/gerirfuncionarios/listar-funcionarios";
    }
}
