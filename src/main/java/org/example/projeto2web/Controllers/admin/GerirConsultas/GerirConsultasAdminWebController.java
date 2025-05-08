package org.example.projeto2web.Controllers.admin.GerirConsultas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/gerirconsultas")
public class GerirConsultasAdminWebController {

    @GetMapping
    public String homeGerirConsultas() {
        return "admin/gerirconsultas/home-gerirconsultas";
    }
}
