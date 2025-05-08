package org.example.projeto2web.Controllers.admin.GerirConsultas;

import org.example.projeto2web.Models.Consulta;
import org.example.projeto2web.Services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ListarConsultasAdminWebController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/gerirconsultas/listar")
    public String listarConsultas(Model model) {
        List<Consulta> consultas = consultaService.listarTodasComRelacionamentos();
        model.addAttribute("consultas", consultas);
        return "admin/gerirconsultas/listar-consultas";
    }
}
