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
import java.util.Optional;

@Controller
@RequestMapping("/rececionista")
public class EditarConsultaWebController {

    @Autowired private ConsultaService consultaService;
    @Autowired private PacienteService pacienteService;
    @Autowired private FuncionarioService funcionarioService;
    @Autowired private TipoConsultaService tipoConsultaService;

    @GetMapping("/editar-consulta")
    public String mostrarFormulario(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id == null) {
            return "rececionista/funcoes/editar-consulta";
        }

        Optional<Consulta> consultaOpt = consultaService.buscarPorId(id);
        if (consultaOpt.isEmpty()) {
            model.addAttribute("erro", "Consulta com ID " + id + " não encontrada.");
            return "rececionista/funcoes/editar-consulta";
        }

        Consulta consulta = consultaOpt.get();
        model.addAttribute("consulta", consulta);
        model.addAttribute("pacientes", pacienteService.listarTodos());
        model.addAttribute("fisioterapeutas", funcionarioService.listarFisioterapeutas());
        model.addAttribute("tiposConsulta", tipoConsultaService.listarTodos());
        model.addAttribute("estados", List.of("agendada", "concluída", "cancelada"));

        return "rececionista/funcoes/editar-consulta";
    }

    @PostMapping("/editar-consulta")
    public String atualizarConsulta(
            @RequestParam("id") Integer id,
            @RequestParam("pacienteId") Integer pacienteId,
            @RequestParam("funcionarioId") Integer funcionarioId,
            @RequestParam("tipoConsultaId") Integer tipoConsultaId,
            @RequestParam("data") String dataStr,
            @RequestParam("hora") String horaStr,
            @RequestParam("estado") String estado,
            Model model) {

        Optional<Consulta> consultaOpt = consultaService.buscarPorId(id);
        if (consultaOpt.isEmpty()) {
            model.addAttribute("erro", "Consulta não encontrada.");
            return "redirect:/rececionista/editar-consulta";
        }

        try {
            LocalDate data = LocalDate.parse(dataStr);
            LocalTime hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));

            Consulta consulta = consultaOpt.get();
            consulta.setIdPaciente(new Paciente(pacienteId));
            consulta.setIdFuncionario(new Funcionario(funcionarioId));
            consulta.setIdTipo(new TipoConsulta(tipoConsultaId));
            consulta.setDataConsulta(data);
            consulta.setHoraConsulta(hora);
            consulta.setEstado(estado);

            consultaService.salvar(consulta);

            model.addAttribute("sucesso", "Consulta atualizada com sucesso.");
            return "redirect:/rececionista/listar-consultas";

        } catch (Exception e) {
            model.addAttribute("erro", "Erro ao atualizar consulta.");
            return "redirect:/rececionista/editar-consulta?id=" + id;
        }
    }
}
