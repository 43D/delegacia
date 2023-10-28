package br.edu.utfpr.td.tsi.delegacia.entity;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.utfpr.td.tsi.delegacia.adapter.placa.CidadeConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.placa.EstadoConverter;
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
        return placa.getPlaca();
    }

    public void setPlaca(PlacaVeiculo placa) {
        this.placa = placa;
    }

    public UnidadeFederacao getEstado() {
        return estado.getEstado();
    }

    public void setEstado(Estado uf) {
        if (uf == null)
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Estado Invalido!!!");
        this.estado = uf;
    }

    public String getCidade() {
        return cidade.getCidade();
    }

    public void setCidade(Cidade cidade) {
        if (cidade == null)
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Cidade Invalido!!!");
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "{placa: " + placa + ", estado: " + estado + ", cidade: " + cidade + "}";
    }

}
