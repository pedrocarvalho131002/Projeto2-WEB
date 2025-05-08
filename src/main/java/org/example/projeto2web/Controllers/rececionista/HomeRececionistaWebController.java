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


    @GetMapping("/logout-rececionista")
    public String logoutRececionista() {
        return "redirect:/login";
    }
}

