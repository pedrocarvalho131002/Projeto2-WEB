package org.example.projeto2web.Controllers.rececionista.Funcoes;

import org.example.projeto2web.Models.Consulta;
import org.example.projeto2web.Models.Funcionario;
import org.example.projeto2web.Models.Paciente;
import org.example.projeto2web.Models.TipoConsulta;
import org.example.projeto2web.Services.ConsultaService;
import org.example.projeto2web.Services.FuncionarioService;
import org.example.projeto2web.Services.PacienteService;
import org.example.projeto2web.Services.TipoConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/rececionista")
public class RegistarConsultaWebController {

    @Autowired private PacienteService pacienteService;
    @Autowired private FuncionarioService funcionarioService;
    @Autowired private TipoConsultaService tipoConsultaService;
    @Autowired private ConsultaService consultaService;

    @GetMapping("/registar-consulta")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        model.addAttribute("fisioterapeutas", funcionarioService.listarFisioterapeutas());
        model.addAttribute("tiposConsulta", tipoConsultaService.listarTodos());
        return "rececionista/funcoes/registar-consulta";
    }

    @PostMapping("/registar-consulta")
    public String submeterConsulta(
            @RequestParam("pacienteId") Integer pacienteId,
            @RequestParam("funcionarioId") Integer funcionarioId,
            @RequestParam("tipoConsultaId") Integer tipoConsultaId,
            @RequestParam("data") String dataStr,
            @RequestParam("hora") String horaStr,
            Model model) {

        if (pacienteId == null || funcionarioId == null || tipoConsultaId == null || dataStr.isEmpty() || horaStr.isEmpty()) {
            model.addAttribute("erro", "Preencha todos os campos.");
            return mostrarFormulario(model);
        }

        try {
            LocalDate data = LocalDate.parse(dataStr);
            LocalTime hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));

            Consulta consulta = new Consulta();
            consulta.setIdPaciente(new Paciente(pacienteId));
            consulta.setIdFuncionario(new Funcionario(funcionarioId));
            consulta.setIdTipo(new TipoConsulta(tipoConsultaId));
            consulta.setDataConsulta(data);
            consulta.setHoraConsulta(hora);
            consulta.setEstado("agendada");

            consultaService.salvar(consulta);

            model.addAttribute("sucesso", "Consulta registada com sucesso.");
            return mostrarFormulario(model);

        } catch (Exception e) {
            model.addAttribute("erro", "Erro ao processar a hora/data.");
            return mostrarFormulario(model);
        }
    }
}
