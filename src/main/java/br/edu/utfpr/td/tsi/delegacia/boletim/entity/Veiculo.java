package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;
import java.util.List;

import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.VeiculosEnum;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.AnoFabricado;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.Cor;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.Marca;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.TipoVeiculo;
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

    public Veiculo(long id, Placa emplacamento, AnoFabricado ano, Cor cor, Marca marca, TipoVeiculo tipoVeiculo,
            List<BoletimFurtoVeiculo> envolvidoEm) {
        this.id = id;
        if (emplacamento == null)
            throw new IllegalStateException("Emplacamento Invalido!!!");
        this.emplacamento = emplacamento;

        this.anoFabricacao = ano.getAno();
        this.cor = cor.getCor();
        this.marca = marca.getMarca();
        this.tipoVeiculo = tipoVeiculo.getVeiculo();
        this.envolvidoEm = envolvidoEm;
    }

    public Veiculo() {
    }

    public short getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(short anoFabricacao) throws Exception {
        this.anoFabricacao = new AnoFabricado(anoFabricacao).getAno();
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) throws Exception {
        this.cor = new Cor(cor).getCor();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws Exception {
        this.marca = new Marca(marca).getMarca();
    }

    public VeiculosEnum getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) throws Exception {
        this.tipoVeiculo = new TipoVeiculo(tipoVeiculo).getVeiculo();
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
