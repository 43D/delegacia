package br.edu.utfpr.td.tsi.delegacia.entity;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.edu.utfpr.td.tsi.delegacia.adapter.endereco.BairroConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.endereco.CidadeConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.endereco.EstadoConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.endereco.LogradouroConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.endereco.NumeroConverter;
import br.edu.utfpr.td.tsi.delegacia.enuns.UnidadeFederacao;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Bairro;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Cidade;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Estado;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Logradouro;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Numero;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "logradouro")
    @Convert(converter = LogradouroConverter.class)
    private Logradouro logradouro;
    @Column(name = "numero")
    @Convert(converter = NumeroConverter.class)
    private Numero numero;
    @Column(name = "bairro")
    @Convert(converter = BairroConverter.class)
    private Bairro bairro;
    @Column(name = "cidade")
    @Convert(converter = CidadeConverter.class)
    private Cidade cidade;
    @Column(name = "estado")
    @Convert(converter = EstadoConverter.class)
    private Estado estado;

    public Endereco(long id, Logradouro logradouro, Numero numero, Bairro bairro, Cidade cidade, Estado estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {
    }

    public String getLogradouro() {
        return (logradouro != null) ? logradouro.getLogradouro() : null;
    }

    public void setLogradouro(Logradouro logradouro) {
        if (logradouro == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Logradouro Invalido!!!");
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return (numero != null) ? numero.getNumero() : null;
    }

    public void setNumero(Numero numero) {
        if (numero == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Numero Invalido!!!");
        this.numero = numero;
    }

    public String getBairro() {
        return (bairro != null) ? bairro.getBairro() : null;
    }

    public void setBairro(Bairro bairro) {
        if (bairro == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bairro Invalido!!!");
        this.bairro = bairro;
    }

    public String getCidade() {
        return (cidade != null) ? cidade.getCidade() : null;
    }

    public void setCidade(Cidade cidade) {
        if (cidade == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cidade Invalido!!!");
        this.cidade = cidade;
    }

    public UnidadeFederacao getEstado() {
        return (estado != null) ? estado.getEstado() : null;
    }

    public void setEstado(Estado estado) {
        if (estado == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado Invalido!!!");
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", logradouro: " + logradouro + ", numero: " + numero + ", bairro: " + bairro
                + ", cidade: " + cidade + ", estado: " + estado + "}";
    }

}
