package org.example.projeto2web.Controllers.admin;

import org.example.projeto2web.Models.Consulta;
import org.example.projeto2web.Models.Pagamento;
import org.example.projeto2web.Models.TipoPagamento;
import org.example.projeto2web.Services.ConsultaService;
import org.example.projeto2web.Services.PagamentoService;
import org.example.projeto2web.Services.TipoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/estatisticas")
public class VerEstatisticasAdminWebController {

    @Autowired private ConsultaService consultaService;
    @Autowired private PagamentoService pagamentoService;
    @Autowired private TipoPagamentoService tipoPagamentoService;

    @GetMapping
    public String verEstatisticas(Model model) {
        List<Consulta> consultas = consultaService.listarTodas();
        List<Pagamento> pagamentos = pagamentoService.listarTodos();
        List<TipoPagamento> tipos = tipoPagamentoService.listarTodos();

        long realizadas = consultas.stream()
                .filter(c -> c.getEstado().equalsIgnoreCase("realizada"))
                .count();

        long agendadas = consultas.stream()
                .filter(c -> c.getEstado().equalsIgnoreCase("agendada"))
                .count();

        double totalPagamentos = pagamentos.stream()
                .mapToDouble(p -> p.getValor() != null ? p.getValor().doubleValue() : 0.0)
                .sum();

        Map<String, Long> distribuicaoTipos = pagamentos.stream()
                .collect(Collectors.groupingBy(
                        p -> {
                            TipoPagamento tipo = p.getIdTipoPagamento();
                            return tipo != null ? tipo.getMetodo() : "Desconhecido";
                        },
                        Collectors.counting()
                ));

        model.addAttribute("realizadas", realizadas);
        model.addAttribute("agendadas", agendadas);
        model.addAttribute("totalPagamentos", totalPagamentos);
        model.addAttribute("distribuicaoTipos", distribuicaoTipos);

        return "admin/ver-estatisticas";
    }
}
