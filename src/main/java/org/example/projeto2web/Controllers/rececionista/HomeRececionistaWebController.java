package org.example.projeto2web.Controllers.rececionista;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rececionista")
public class HomeRececionistaWebController {

    @GetMapping("/home")
    public String homeRececionista() {
        return "rececionista/home-rececionista";
    }

    @GetMapping("/rececionista/registar-consulta")
    public String registarConsulta() {
        return "rececionista/registar-consulta";
    }

    @GetMapping("/rececionista/editar-consulta")
    public String editarConsulta() {
        return "rececionista/editar-consulta";
    }

    @GetMapping("/rececionista/listar-consultas")
    public String listarConsultas() {
        return "rececionista/listar-consultas";
    }

    @GetMapping("/logout-rececionista")
    public String logoutRececionista() {
        return "redirect:/login";
    }
}
