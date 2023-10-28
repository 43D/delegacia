package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte.EmailConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte.EnvolvimentoConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte.NomeConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte.TelefoneConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.EmailValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.EnvolvimentoValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.NomeValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.TelefoneValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Parte")
public class Parte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "nome")
    @Convert(converter = NomeConverter.class)
    private NomeValidator nome;
    @Column(name = "email")
    @Convert(converter = EmailConverter.class)
    private EmailValidator email;
    @Column(name = "telefone")
    @Convert(converter = TelefoneConverter.class)
    private TelefoneValidator telefone;
    @Column(name = "tipoEnvolvimento")
    @Convert(converter = EnvolvimentoConverter.class)
    private EnvolvimentoValidator tipoEnvolvimento;

    public Parte(long id, NomeValidator nome, EmailValidator email, TelefoneValidator telefone,
            EnvolvimentoValidator tipoEnvolvimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoEnvolvimento = tipoEnvolvimento;
    }

    public Parte() {
    }

    public String getNome() {
        return nome.getNome();
    }

    public void setNome(NomeValidator nome) {
        if (nome == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome Invalido!!!");
        this.nome = nome;
    }

    public String getEmail() {
        return email.toString();
    }

    public void setEmail(EmailValidator email) {
        if (email == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email Invalido!!!");
        this.email = email;
    }

    public String getTelefone() {
        return telefone.getTelefone();
    }

    public void setTelefone(TelefoneValidator telefone) {
        if (telefone == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Telefone Invalido!!!");
        this.telefone = telefone;
    }

    public String getTipoEnvolvimento() {
        return tipoEnvolvimento.getEnvolvimento();
    }

    public void setTipoEnvolvimento(EnvolvimentoValidator tipoEnvolvimento) {
        if (tipoEnvolvimento == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "tipoEnvolvimento Invalido!!!");
        this.tipoEnvolvimento = tipoEnvolvimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{id:" + id + ", nome:" + nome + ", email:" + email + ", telefone:" + telefone
                + ", tipoEnvolvimento:" + tipoEnvolvimento + "}";
    }

}
