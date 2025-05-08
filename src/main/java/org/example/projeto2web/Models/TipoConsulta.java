package org.example.projeto2web.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tipo_consulta")
public class TipoConsulta {
    @Id
    @ColumnDefault("nextval('tipo_consulta_id_tipo_consulta_seq')")
    @Column(name = "id_tipo_consulta", nullable = false)
    private Integer id;

    @Column(name = "metodo", nullable = false, length = 50)
    private String metodo;

    public TipoConsulta() {
    }

    public TipoConsulta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

}