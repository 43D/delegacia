package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;

import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.UnidadeFederacao;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.Cidade;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.Estado;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.PlacaVeiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Emplacamento")
public class Placa implements Serializable{

    @Id
    @Column(name = "placa")
    private String placa;

    @Column(name = "estado")
    private UnidadeFederacao estado;

    @Column(name = "cidade")
    private String cidade;

    public Placa(PlacaVeiculo placa, Estado estado, Cidade cidade) {
        this.placa = placa.getPlaca();
        this.estado = estado.getEstado();
        this.cidade = cidade.getCidade();
    }

    public Placa() {
    }
    
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) throws Exception {
        this.placa = new PlacaVeiculo(placa).getPlaca();
    }
    public UnidadeFederacao getEstado() {
        return estado;
    }
    public void setEstado(String estado) throws Exception {
        this.estado = new Estado(estado).getEstado();
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) throws Exception {
        this.cidade = new Cidade(cidade).getCidade();
    }
    @Override
    public String toString() {
        return "{placa: " + placa + ", estado: " + estado + ", cidade: " + cidade + "}";
    }

}
