package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;

import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa.CidadeConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa.EstadoConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.UnidadeFederacao;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.Cidade;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.Estado;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.PlacaVeiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emplacamento")
public class Placa implements Serializable {

    @Id
    @Column(name = "placa")
    private String placa;

    @Column(name = "estado")
    @Convert(converter = EstadoConverter.class)
    private Estado estado;

    @Column(name = "cidade")
    @Convert(converter = CidadeConverter.class)
    private Cidade cidade;

    public Placa(PlacaVeiculo placa, Estado uf, Cidade cidade) {
        this.placa = placa.getPlaca();
        this.estado = uf;
        this.cidade = cidade;
    }

    public Placa() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = new PlacaVeiculo(placa).getPlaca();
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
