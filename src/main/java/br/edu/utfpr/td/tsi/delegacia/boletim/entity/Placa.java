package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa.CidadeConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa.EstadoConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa.PlacaConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.UnidadeFederacao;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.Cidade;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.Estado;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.PlacaVeiculo;
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
            throw new IllegalStateException("Estado Invalido!!!");
        this.estado = uf;
    }

    public String getCidade() {
        return cidade.getCidade();
    }

    public void setCidade(Cidade cidade) {
        if (cidade == null)
            throw new IllegalStateException("Cidade Invalido!!!");
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "{placa: " + placa + ", estado: " + estado + ", cidade: " + cidade + "}";
    }

}
