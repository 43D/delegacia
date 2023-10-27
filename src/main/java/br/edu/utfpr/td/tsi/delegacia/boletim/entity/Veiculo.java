package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;
import java.util.List;

import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.VeiculosEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Veiculo")
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Placa emplacamento;

    @Column(name = "anoFabricacao")
    private short anoFabricacao;
    @Column(name = "cor")
    private String cor;
    @Column(name = "marca")
    private String marca;
    @Column(name = "tipoVeiculo")
    private VeiculosEnum tipoVeiculo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "envolvidoEm")
    private List<BoletimFurtoVeiculo> envolvidoEm;

    public Veiculo(long id, Placa emplacamento, short anoFabricacao, String cor, String marca, VeiculosEnum tipoVeiculo,
            List<BoletimFurtoVeiculo> envolvidoEm) {
        this.id = id;
        this.emplacamento = emplacamento;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.marca = marca;
        this.tipoVeiculo = tipoVeiculo;
        this.envolvidoEm = envolvidoEm;
    }

    public Veiculo() {
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

    public VeiculosEnum getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(VeiculosEnum tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Placa getEmplacamento() {
        return emplacamento;
    }

    public void setEmplacamento(Placa emplacamento) {
        this.emplacamento = emplacamento;
    }

    public List<BoletimFurtoVeiculo> getEnvolvidoEm() {
        return envolvidoEm;
    }

    public void setEnvolvidoEm(List<BoletimFurtoVeiculo> envolvidoEm) {
        this.envolvidoEm = envolvidoEm;
    }

    public void addEnvolvidoEm(BoletimFurtoVeiculo envolvido) {
        this.envolvidoEm.add(envolvido);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", emplacamento: " + emplacamento + ", anoFabricacao: " + anoFabricacao + ", cor: "
                + cor + ", marca: " + marca + ", tipoVeiculo: " + tipoVeiculo + ", envolvidoEm: " + envolvidoEm + "}";
    }

}
