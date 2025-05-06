package org.example.projeto2web.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tipo_funcionario")
public class TipoFuncionario {
    @Id
    @ColumnDefault("nextval('tipo_funcionario_id_tipo_funcionario_seq')")
    @Column(name = "id_tipo_funcionario", nullable = false)
    private Integer id;

    @Column(name = "cargo", nullable = false, length = 100)
    private String cargo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}