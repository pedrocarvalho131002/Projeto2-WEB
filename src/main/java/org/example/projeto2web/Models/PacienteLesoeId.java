package org.example.projeto2web.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PacienteLesoeId implements Serializable {
    private static final long serialVersionUID = -8635170892447142133L;
    @Column(name = "paciente_id_paciente", nullable = false)
    private Integer pacienteIdPaciente;

    @Column(name = "lesoes_id_lesao", nullable = false)
    private Integer lesoesIdLesao;

    public Integer getPacienteIdPaciente() {
        return pacienteIdPaciente;
    }

    public void setPacienteIdPaciente(Integer pacienteIdPaciente) {
        this.pacienteIdPaciente = pacienteIdPaciente;
    }

    public Integer getLesoesIdLesao() {
        return lesoesIdLesao;
    }

    public void setLesoesIdLesao(Integer lesoesIdLesao) {
        this.lesoesIdLesao = lesoesIdLesao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PacienteLesoeId entity = (PacienteLesoeId) o;
        return Objects.equals(this.pacienteIdPaciente, entity.pacienteIdPaciente) &&
                Objects.equals(this.lesoesIdLesao, entity.lesoesIdLesao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacienteIdPaciente, lesoesIdLesao);
    }

}