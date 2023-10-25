package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.util.ArrayList;

public class Veiculo {
    private Emplacamento emplacamento;
    private short anoFabricacao;
    private String cor;
    private String marca;
    private String tipoVeiculo;
    private ArrayList<BoletimFurtoVeiculo> envolvidoEm; 

    public Veiculo(short anoFabricacao, String cor, String marca, String tipoVeiculo, Emplacamento emplacamento, BoletimFurtoVeiculo envolvido) {
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.marca = marca;
        this.tipoVeiculo = tipoVeiculo;
        this.emplacamento = emplacamento;
        this.envolvidoEm.add(envolvido);
    }
    public short getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(short anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getTipoVeiculo() {
        return tipoVeiculo;
    }
    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    public Emplacamento getEmplacamento() {
        return emplacamento;
    }
    public void setEmplacamento(Emplacamento emplacamento) {
        this.emplacamento = emplacamento;
    }
    public ArrayList<BoletimFurtoVeiculo> getEnvolvidoEm() {
        return envolvidoEm;
    }
    public void setEnvolvidoEm(ArrayList<BoletimFurtoVeiculo> envolvidoEm) {
        this.envolvidoEm = envolvidoEm;
    }
    public void addEnvolvidoEm(BoletimFurtoVeiculo envolvido) {
        this.envolvidoEm.add(envolvido);
    }
}
