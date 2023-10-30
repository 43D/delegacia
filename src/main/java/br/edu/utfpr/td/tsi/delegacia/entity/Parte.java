package br.edu.utfpr.td.tsi.delegacia.entity;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.edu.utfpr.td.tsi.delegacia.adapter.parte.EmailConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.parte.EnvolvimentoConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.parte.NomeConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.parte.TelefoneConverter;
import br.edu.utfpr.td.tsi.delegacia.values.parte.EmailParte;
import br.edu.utfpr.td.tsi.delegacia.values.parte.EnvolvimentoParte;
import br.edu.utfpr.td.tsi.delegacia.values.parte.NomeParte;
import br.edu.utfpr.td.tsi.delegacia.values.parte.TelefoneParte;
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
    private NomeParte nome;
    @Column(name = "email")
    @Convert(converter = EmailConverter.class)
    private EmailParte email;
    @Column(name = "telefone")
    @Convert(converter = TelefoneConverter.class)
    private TelefoneParte telefone;
    @Column(name = "tipoEnvolvimento")
    @Convert(converter = EnvolvimentoConverter.class)
    private EnvolvimentoParte tipoEnvolvimento;

    public Parte(NomeParte nome, EmailParte email, TelefoneParte telefone,
            EnvolvimentoParte tipoEnvolvimento) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoEnvolvimento = tipoEnvolvimento;
    }

    public Parte() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return (nome != null) ? nome.getNome() : null;
    }

    public void setNome(NomeParte nome) {
        if (nome == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome Invalido!!!");
        this.nome = nome;
    }

    public EmailParte getEmail() {
        return email;
    }

    public void setEmail(EmailParte email) {
        if (email == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email Invalido!!!");
        this.email = email;
    }

    public TelefoneParte getTelefone() {
        return telefone;
    }

    public void setTelefone(TelefoneParte telefone) {
        if (telefone == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Telefone Invalido!!!");
        this.telefone = telefone;
    }

    public EnvolvimentoParte getTipoEnvolvimento() {
        return tipoEnvolvimento;
    }

    public void setTipoEnvolvimento(EnvolvimentoParte tipoEnvolvimento) {
        if (tipoEnvolvimento == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "tipoEnvolvimento Invalido!!!");
        this.tipoEnvolvimento = tipoEnvolvimento;
    }

    @Override
    public String toString() {
        return "{id:" + id + ", nome:" + nome + ", email:" + email + ", telefone:" + telefone
                + ", tipoEnvolvimento:" + tipoEnvolvimento + "}";
    }

}
