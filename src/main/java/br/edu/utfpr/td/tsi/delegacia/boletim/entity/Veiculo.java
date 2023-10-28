package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;
import java.util.List;

import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo.AnoValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo.CorValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo.MarcaValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo.TipoVeiculoValidator;
import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.VeiculosEnum;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.AnoFabricado;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.Cor;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.Marca;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.TipoVeiculo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
    @Convert(converter = AnoValidator.class)
    private AnoFabricado anoFabricacao;
    @Column(name = "cor")
    @Convert(converter = CorValidator.class)
    private Cor cor;
    @Column(name = "marca")
    @Convert(converter = MarcaValidator.class)
    private Marca marca;
    @Column(name = "tipoVeiculo")
    @Convert(converter = TipoVeiculoValidator.class)
    private TipoVeiculo tipoVeiculo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "envolvidoEm")
    private List<BoletimFurtoVeiculo> envolvidoEm;

    public Veiculo(long id, Placa emplacamento, AnoFabricado ano, Cor cor, Marca marca, TipoVeiculo tipoVeiculo,
            List<BoletimFurtoVeiculo> envolvidoEm) {
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

    public short getAnoFabricacao() {
        return anoFabricacao.getAno();
    }

    public void setAnoFabricacao(AnoFabricado anoFabricacao) {
        if (anoFabricacao == null)
            throw new IllegalStateException("AnoFabricado Invalido!!!");
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor.getCor();
    }

    public void setCor(Cor cor) {
        if (cor == null)
            throw new IllegalStateException("Cor Invalido!!!");
        this.cor = cor;
    }

    public String getMarca() {
        return marca.getMarca();
    }

    public void setMarca(Marca marca) {
        if (marca == null)
            throw new IllegalStateException("Marca Invalido!!!");
        this.marca = marca;
    }

    public VeiculosEnum getTipoVeiculo() {
        return tipoVeiculo.getVeiculo();
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
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
