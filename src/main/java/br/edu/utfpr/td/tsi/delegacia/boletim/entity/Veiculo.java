package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo.AnoConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo.CorConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo.MarcaConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo.TipoVeiculoConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.VeiculosEnum;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.AnoFabricadoValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.CorValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.MarcaValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.TipoVeiculoValidator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Veiculo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Placa emplacamento;
    @Column(name = "anoFabricacao")
    @Convert(converter = AnoConverter.class)
    private AnoFabricadoValidator anoFabricacao;
    @Column(name = "cor")
    @Convert(converter = CorConverter.class)
    private CorValidator cor;
    @Column(name = "marca")
    @Convert(converter = MarcaConverter.class)
    private MarcaValidator marca;
    @Column(name = "tipoVeiculo")
    @Convert(converter = TipoVeiculoConverter.class)
    private TipoVeiculoValidator tipoVeiculo;
    @OneToOne
    @PrimaryKeyJoinColumn
    private BoletimFurtoVeiculo envolvidoEm;

    public Veiculo(long id, Placa emplacamento, AnoFabricadoValidator ano, CorValidator cor, MarcaValidator marca, TipoVeiculoValidator tipoVeiculo,
            BoletimFurtoVeiculo envolvidoEm) {
        this.id = id;
        if (emplacamento == null)
            throw new IllegalStateException("Emplacamento Invalido!!!");
        this.emplacamento = emplacamento;
        this.anoFabricacao = ano;
        this.cor = cor;
        this.marca = marca;
        this.tipoVeiculo = tipoVeiculo;
        this.envolvidoEm = envolvidoEm;
    }

    public Veiculo() {

    }

    public Integer getAnoFabricacao() {
        return anoFabricacao.getAno();
    }

    public void setAnoFabricacao(AnoFabricadoValidator anoFabricacao) {
        if (anoFabricacao == null)
            throw new IllegalStateException("AnoFabricado Invalido!!!");
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor.getCor();
    }

    public void setCor(CorValidator cor) {
        if (cor == null)
            throw new IllegalStateException("Cor Invalido!!!");
        this.cor = cor;
    }

    public String getMarca() {
        return marca.getMarca();
    }

    public void setMarca(MarcaValidator marca) {
        if (marca == null)
            throw new IllegalStateException("Marca Invalido!!!");
        this.marca = marca;
    }

    public VeiculosEnum getTipoVeiculo() {
        return tipoVeiculo.getVeiculo();
    }

    public void setTipoVeiculo(TipoVeiculoValidator tipoVeiculo) {
        if (tipoVeiculo == null)
            throw new IllegalStateException("TipoVeiculo Invalido!!!");
        this.tipoVeiculo = tipoVeiculo;
    }

    public Placa getEmplacamento() {
        return emplacamento;
    }

    public void setEmplacamento(Placa emplacamento) {
        if (emplacamento == null)
            throw new IllegalStateException("Emplacamento Invalido!!!");
        this.emplacamento = emplacamento;
    }

    public BoletimFurtoVeiculo getEnvolvidoEm() {
        return envolvidoEm;
    }

    public void setEnvolvidoEm(BoletimFurtoVeiculo envolvidoEm) {
        this.envolvidoEm = envolvidoEm;
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
