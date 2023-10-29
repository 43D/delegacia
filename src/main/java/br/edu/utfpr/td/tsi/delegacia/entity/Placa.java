package br.edu.utfpr.td.tsi.delegacia.entity;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.utfpr.td.tsi.delegacia.adapter.endereco.CidadeConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.endereco.EstadoConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.placa.PlacaConverter;
import br.edu.utfpr.td.tsi.delegacia.enuns.UnidadeFederacao;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Cidade;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Estado;
import br.edu.utfpr.td.tsi.delegacia.values.placa.PlacaVeiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emplacamento")
public class Placa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "placa")
    @Convert(converter = PlacaConverter.class)
    private PlacaVeiculo placa;

    @Column(name = "estado")
    @Convert(converter = EstadoConverter.class)
    private Estado estado;

    @Column(name = "cidade")
    @Convert(converter = CidadeConverter.class)
    private Cidade cidade;

    public Placa(PlacaVeiculo placa, Estado uf, Cidade cidade) {
        this.placa = placa;
        this.estado = uf;
        this.cidade = cidade;
    }

    public Placa() {
    }

    public String getPlaca() {
        return (placa != null) ? placa.getPlaca() : null;
    }

    public void setPlaca(PlacaVeiculo placa) {
        this.placa = placa;
    }

    public UnidadeFederacao getEstado() {
        return (estado != null) ? estado.getEstado() : null;
    }

    public void setEstado(Estado uf) {
        if (uf == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado Invalido!!!");
        this.estado = uf;
    }

    public String getCidade() {
        return (cidade != null) ? cidade.getCidade() : null;
    }

    public void setCidade(Cidade cidade) {
        if (cidade == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cidade Invalido!!!");
        this.cidade = cidade;
    }

    
    @Override
    public String toString() {
        return "{placa: " + placa + ", estado: " + estado + ", cidade: " + cidade + "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
