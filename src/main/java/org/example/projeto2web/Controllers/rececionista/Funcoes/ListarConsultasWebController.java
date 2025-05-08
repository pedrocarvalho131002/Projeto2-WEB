package org.example.projeto2web.Controllers.rececionista.Funcoes;

import org.example.projeto2web.Models.Consulta;
import org.example.projeto2web.Services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rececionista")
public class ListarConsultasWebController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/listar-consultas")
    public String listarConsultas(Model model) {
        List<Consulta> consultas = consultaService.listarTodasComRelacionamentos();
        model.addAttribute("consultas", consultas);
        return "rececionista/funcoes/listar-consultas";
    }
}
