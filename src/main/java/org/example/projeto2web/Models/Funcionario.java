package org.example.projeto2web.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @ColumnDefault("nextval('funcionario_id_funcionario_seq')")
    @Column(name = "id_funcionario", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo")
    private org.example.projeto2web.Models.TipoFuncionario idTipo;

    @Column(name = "nif", nullable = false, length = 20)
    private String nif;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "codigo_postal", nullable = false, length = 20)
    private String codigoPostal;

    @Column(name = "localidade", nullable = false, length = 100)
    private String localidade;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "cidade", nullable = false, length = 50)
    private String cidade;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "n_telemovel", nullable = false, length = 20)
    private String nTelemovel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public org.example.projeto2web.Models.TipoFuncionario getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(org.example.projeto2web.Models.TipoFuncionario idTipo) {
        this.idTipo = idTipo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNTelemovel() {
        return nTelemovel;
    }

    public void setNTelemovel(String nTelemovel) {
        this.nTelemovel = nTelemovel;
    }

}