package org.example.projeto2web.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientelesao")
public class Pacientelesao {
    @EmbeddedId
    private PacientelesaoId id;

    @MapsId("idPaciente")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente idPaciente;

    @MapsId("idLesao")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lesao", nullable = false)
    private Lesoe idLesao;

    public PacientelesaoId getId() {
        return id;
    }

    public void setId(PacientelesaoId id) {
        this.id = id;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Lesoe getIdLesao() {
        return idLesao;
    }

    public void setIdLesao(Lesoe idLesao) {
        this.idLesao = idLesao;
    }

}