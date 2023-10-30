package br.edu.utfpr.td.tsi.delegacia.dto;

import java.io.Serializable;

import br.edu.utfpr.td.tsi.delegacia.entity.Placa;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Cidade;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Estado;
import br.edu.utfpr.td.tsi.delegacia.values.placa.PlacaVeiculo;

public class PlacaDTO implements Serializable {

    private PlacaVeiculo placa;
    private Estado estado;
    private Cidade cidade;

    public PlacaDTO(Placa emplacamento) {
        this.placa = emplacamento.getPlaca();
        this.cidade = emplacamento.getCidade();
        this.estado = emplacamento.getEstado();
    }

    public String getPlaca() {
        return placa.toString();
    }

    public String getEstado() {
        return estado.getEstado().toString();
    }

    public String getCidade() {
        return cidade.toString();
    }
}
