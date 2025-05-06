package org.example.projeto2web.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConsultafuncionarioId implements Serializable {
    private static final long serialVersionUID = 8929218764275620139L;
    @Column(name = "id_consulta", nullable = false)
    private Integer idConsulta;

    @Column(name = "id_funcionario", nullable = false)
    private Integer idFuncionario;

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ConsultafuncionarioId entity = (ConsultafuncionarioId) o;
        return Objects.equals(this.idFuncionario, entity.idFuncionario) &&
                Objects.equals(this.idConsulta, entity.idConsulta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFuncionario, idConsulta);
    }

}