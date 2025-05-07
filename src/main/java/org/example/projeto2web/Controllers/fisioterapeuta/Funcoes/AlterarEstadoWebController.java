package org.example.projeto2web.Controllers.fisioterapeuta.Funcoes;

import org.example.projeto2web.Controllers.LoginController;
import org.example.projeto2web.Models.Consulta;
import org.example.projeto2web.Services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/fisioterapeuta")
public class AlterarEstadoWebController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/alterar-estado")
    public String mostrarFormularioAlterarEstado(Model model) {
        model.addAttribute("estados", List.of("AGENDADA", "REALIZADA", "CANCELADA"));
        return "fisioterapeuta/funcoes/alterar-estado";
    }

    @PostMapping("/alterar-estado")
    public String atualizarEstadoConsulta(@RequestParam("idConsulta") Integer idConsulta,
                                          @RequestParam("estado") String novoEstado,
                                          Model model) {
        Optional<Consulta> optConsulta = consultaService.buscarPorId(idConsulta);

        model.addAttribute("estados", List.of("AGENDADA", "REALIZADA", "CANCELADA"));

        if (optConsulta.isEmpty()) {
            model.addAttribute("mensagem", "Consulta não encontrada.");
            return "fisioterapeuta/funcoes/alterar-estado";
        }

        Consulta consulta = optConsulta.get();
        Integer fisioterapeutaId = LoginController.fisioterapeutaLogadoId;

        if (!consulta.getIdFuncionario().getId().equals(fisioterapeutaId)) {
            model.addAttribute("mensagem", "Sem permissão para alterar esta consulta.");
            return "fisioterapeuta/funcoes/alterar-estado";
        }

        consulta.setEstado(novoEstado);
        consultaService.salvar(consulta);
        model.addAttribute("mensagem", "Estado atualizado com sucesso.");
        return "redirect:/fisioterapeuta/home";
    }
}
