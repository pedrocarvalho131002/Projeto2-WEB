package org.example.projeto2web.Controllers.admin.GerirFuncionarios;

import org.example.projeto2web.Models.Funcionario;
import org.example.projeto2web.Models.TipoFuncionario;
import org.example.projeto2web.Services.FuncionarioService;
import org.example.projeto2web.Services.TipoFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/GerirFuncionarios")
public class CriarFuncionarioAdminWebController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private TipoFuncionarioService tipoFuncionarioService;

    @GetMapping("/criar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tiposFuncionario", tipoFuncionarioService.listarTodos());
        model.addAttribute("funcionario", new Funcionario());
        return "admin/gerirfuncionarios/criar-funcionario";
    }


    @PostMapping("/criar")
    public String submeterFuncionario(
            @RequestParam("nome") String nome,
            @RequestParam("tipoId") Integer tipoId,
            @RequestParam("email") String email,
            @RequestParam("nif") String nif,
            @RequestParam("codigoPostal") String codigoPostal,
            @RequestParam("localidade") String localidade,
            @RequestParam("rua") String rua,
            @RequestParam("cidade") String cidade,
            @RequestParam("password") String password,
            @RequestParam("nTelemovel") String nTelemovel,
            Model model) {

        if (nome.isBlank() || email.isBlank() || tipoId == null) {
            model.addAttribute("erro", "Preencha todos os campos obrigatórios.");
            return mostrarFormulario(model);
        }

        Funcionario f = new Funcionario();
        f.setNome(nome);
        f.setEmail(email);
        f.setIdTipo(new TipoFuncionario());
        f.getIdTipo().setId(tipoId);
        f.setNif(nif);
        f.setCodigoPostal(codigoPostal);
        f.setLocalidade(localidade);
        f.setRua(rua);
        f.setCidade(cidade);
        f.setPassword(password);
        f.setNTelemovel(nTelemovel);

        funcionarioService.salvar(f);
        model.addAttribute("sucesso", "Funcionário criado com sucesso.");
        return mostrarFormulario(model);
    }
}
