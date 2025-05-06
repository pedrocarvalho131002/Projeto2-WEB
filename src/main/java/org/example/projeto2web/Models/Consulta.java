package org.example.projeto2web.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consulta")
public class Consulta {
    @Id
    @ColumnDefault("nextval('consulta_id_consulta_seq')")
    @Column(name = "id_consulta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo")
    private org.example.projeto2web.Models.TipoConsulta idTipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private org.example.projeto2web.Models.Paciente idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario")
    private org.example.projeto2web.Models.Funcionario idFuncionario;

    @Column(name = "data_consulta", nullable = false)
    private LocalDate dataConsulta;

    @Column(name = "hora_consulta", nullable = false)
    private LocalTime horaConsulta;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public org.example.projeto2web.Models.TipoConsulta getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(org.example.projeto2web.Models.TipoConsulta idTipo) {
        this.idTipo = idTipo;
    }

    public org.example.projeto2web.Models.Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(org.example.projeto2web.Models.Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public org.example.projeto2web.Models.Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(org.example.projeto2web.Models.Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}