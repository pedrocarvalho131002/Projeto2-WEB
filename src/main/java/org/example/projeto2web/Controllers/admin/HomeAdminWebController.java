package org.example.projeto2web.Controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeAdminWebController {

    @GetMapping("/home")
    public String homeAdmin() {
        return "admin/home-admin";
    }

    @GetMapping("/gerir-funcionarios")
    public String gerirFuncionarios() {
        return "admin/gerir-funcionarios";
    }

    @GetMapping("/gerir-consultas")
    public String gerirConsultas() {
        return "admin/gerir-consultas";
    }

    @GetMapping("/ver-estatisticas")
    public String verEstatisticas() {
        return "admin/ver-estatisticas";
    }

    @GetMapping("/logout-admin")
    public String logoutAdmin() {
        return "redirect:/login";
    }

}
