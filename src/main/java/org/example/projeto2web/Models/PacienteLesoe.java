package org.example.projeto2web.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente_lesoes")
public class PacienteLesoe {
    @EmbeddedId
    private PacienteLesoeId id;

    @MapsId("pacienteIdPaciente")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id_paciente", nullable = false)
    private Paciente pacienteIdPaciente;

    @MapsId("lesoesIdLesao")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesoes_id_lesao", nullable = false)
    private Lesoe lesoesIdLesao;

    public PacienteLesoeId getId() {
        return id;
    }

    public void setId(PacienteLesoeId id) {
        this.id = id;
    }

    public Paciente getPacienteIdPaciente() {
        return pacienteIdPaciente;
    }

    public void setPacienteIdPaciente(Paciente pacienteIdPaciente) {
        this.pacienteIdPaciente = pacienteIdPaciente;
    }

    public Lesoe getLesoesIdLesao() {
        return lesoesIdLesao;
    }

    public void setLesoesIdLesao(Lesoe lesoesIdLesao) {
        this.lesoesIdLesao = lesoesIdLesao;
    }

}