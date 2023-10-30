package br.edu.utfpr.td.tsi.delegacia.dto;

import java.io.Serializable;

import br.edu.utfpr.td.tsi.delegacia.entity.Veiculo;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.AnoFabricado;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.Cor;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.Marca;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.TipoVeiculo;

public class VeiculoDTO implements Serializable {

    private long id;
    private PlacaDTO emplacamento;
    private AnoFabricado anoFabricacao;
    private Cor cor;
    private Marca marca;
    private TipoVeiculo tipoVeiculo;
    private BoletimFurtoVeiculoDTO envolvidoEm;
    
    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.emplacamento = new PlacaDTO(veiculo.getEmplacamento());
        this.anoFabricacao = veiculo.getAnoFabricacao();
        this.cor = veiculo.getCor();
        this.marca = veiculo.getMarca();
        this.tipoVeiculo = veiculo.getTipoVeiculo();
        this.envolvidoEm = new BoletimFurtoVeiculoDTO(veiculo.getEnvolvidoEm().getId(), veiculo.getEnvolvidoEm().getCrime());
    }

    public long getId() {
        return id;
    }

    public PlacaDTO getEmplacamento() {
        return emplacamento;
    }

    public String getAnoFabricacao() {
        return anoFabricacao.toString();
    }

    public String getCor() {
        return cor.toString();
    }

    public String getMarca() {
        return marca.toString();
    }

    public String getTipoVeiculo() {
        return tipoVeiculo.toString();
    }

    public BoletimFurtoVeiculoDTO getEnvolvidoEm() {
        return envolvidoEm;
    }

    
}
