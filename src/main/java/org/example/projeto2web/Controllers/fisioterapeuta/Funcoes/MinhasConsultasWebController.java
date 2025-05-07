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
public class MinhasConsultasWebController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/minhas-consultas")
    public String mostrarMinhasConsultas(Model model) {
        Integer fisioterapeutaId = LoginController.fisioterapeutaLogadoId;
        if (fisioterapeutaId == null) {
            model.addAttribute("consultas", List.of());
        } else {
            List<Consulta> consultas = consultaService.listarPorFuncionario(fisioterapeutaId);
            model.addAttribute("consultas", consultas);
        }
        return "fisioterapeuta/funcoes/minhas-consultas";
    }
}
