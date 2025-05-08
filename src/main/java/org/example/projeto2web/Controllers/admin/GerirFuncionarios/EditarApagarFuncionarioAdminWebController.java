package org.example.projeto2web.Controllers.admin.GerirFuncionarios;

import org.example.projeto2web.Models.Funcionario;
import org.example.projeto2web.Models.TipoFuncionario;
import org.example.projeto2web.Services.FuncionarioService;
import org.example.projeto2web.Services.TipoFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/GerirFuncionarios")
public class EditarApagarFuncionarioAdminWebController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private TipoFuncionarioService tipoFuncionarioService;

    @GetMapping("/editar")
    public String mostrarFormulario(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id == null) {
            model.addAttribute("modo", "pesquisa");
            return "admin/gerirfuncionarios/editar-apagar-funcionario";
        }

        Optional<Funcionario> funcionarioOpt = funcionarioService.buscarPorId(id);
        if (funcionarioOpt.isEmpty()) {
            model.addAttribute("erro", "Funcionário com ID " + id + " não encontrado.");
            model.addAttribute("modo", "pesquisa");
            return "admin/gerirfuncionarios/editar-apagar-funcionario";
        }

        model.addAttribute("funcionario", funcionarioOpt.get());
        model.addAttribute("tiposFuncionario", tipoFuncionarioService.listarTodos());
        model.addAttribute("modo", "edicao");
        return "admin/gerirfuncionarios/editar-apagar-funcionario";
    }

    @PostMapping("/editar")
    public String editarFuncionario(
            @ModelAttribute Funcionario funcionario,
            @RequestParam("tipoId") Integer tipoId,
            Model model) {

        TipoFuncionario tipo = tipoFuncionarioService.buscarPorId(tipoId)
                .orElseThrow(() -> new IllegalArgumentException("Tipo de funcionário inválido"));

        funcionario.setIdTipo(tipo);
        funcionarioService.salvar(funcionario);

        model.addAttribute("sucesso", "Funcionário atualizado com sucesso.");
        model.addAttribute("modo", "pesquisa");
        return "admin/gerirfuncionarios/editar-apagar-funcionario";
    }

    @PostMapping("/apagar")
    public String apagarFuncionario(@RequestParam("id") Integer id, Model model) {
        funcionarioService.deletar(id);
        model.addAttribute("sucesso", "Funcionário removido com sucesso.");
        model.addAttribute("modo", "pesquisa");
        return "admin/gerirfuncionarios/editar-apagar-funcionario";
    }
}
