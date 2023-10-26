package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Parte")
public class Parte implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column( name = "id")
    private long id;
    @Column( name = "nome")
    private String nome;
    @Column( name = "email")
    private String email;
    @Column( name = "telefone")
    private String telefone;
    @Column( name = "tipoEnvolvimento")
    private String tipoEnvolvimento;

    
    public Parte(long id, String nome, String email, String telefone, String tipoEnvolvimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoEnvolvimento = tipoEnvolvimento;
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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTipoEnvolvimento() {
        return tipoEnvolvimento;
    }
    public void setTipoEnvolvimento(String tipoEnvolvimento) {
        this.tipoEnvolvimento = tipoEnvolvimento;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    

}
