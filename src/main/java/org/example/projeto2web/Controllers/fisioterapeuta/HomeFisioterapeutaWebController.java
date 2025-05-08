package org.example.projeto2web.Controllers.fisioterapeuta;

import org.example.projeto2web.Controllers.LoginController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fisioterapeuta")
public class HomeFisioterapeutaWebController {

    @GetMapping("/home")
    public String homeFisioterapeuta() {
        return "fisioterapeuta/home-fisioterapeuta";
    }

    @GetMapping("/fisioterapeuta/minhas-consultas")
    public String minhasConsultas() {
        return "fisioterapeuta/minhas-consultas";
    }

    @GetMapping("/fisioterapeuta/alterar-estado")
    public String alterarEstado() {
        return "fisioterapeuta/alterar-estado";
    }

    @GetMapping("/logout-fisio")
    public String logoutFisioterapeuta() {
        LoginController.fisioterapeutaLogadoId = null; // limpa o login
        return "redirect:/login";
    }

}
