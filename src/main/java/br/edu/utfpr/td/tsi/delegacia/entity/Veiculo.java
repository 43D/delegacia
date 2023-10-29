package br.edu.utfpr.td.tsi.delegacia.entity;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.utfpr.td.tsi.delegacia.adapter.veiculo.AnoConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.veiculo.CorConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.veiculo.MarcaConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.veiculo.TipoVeiculoConverter;
import br.edu.utfpr.td.tsi.delegacia.enuns.VeiculosEnum;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.AnoFabricado;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.Cor;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.Marca;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.TipoVeiculo;
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
    private AnoFabricado anoFabricacao;
    @Column(name = "cor")
    @Convert(converter = CorConverter.class)
    private Cor cor;
    @Column(name = "marca")
    @Convert(converter = MarcaConverter.class)
    private Marca marca;
    @Column(name = "tipoVeiculo")
    @Convert(converter = TipoVeiculoConverter.class)
    private TipoVeiculo tipoVeiculo;
    @OneToOne
    @PrimaryKeyJoinColumn
    private BoletimFurtoVeiculo envolvidoEm;

    

    public Veiculo(Placa emplacamento, AnoFabricado anoFabricacao, Cor cor, Marca marca,
            TipoVeiculo tipoVeiculo) {
        this.emplacamento = emplacamento;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.marca = marca;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Veiculo() {
    }

    public Integer getAnoFabricacao() {
        return (anoFabricacao != null) ? anoFabricacao.getAno() : null;
    }

    public void setAnoFabricacao(AnoFabricado anoFabricacao) {
        if (anoFabricacao == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "AnoFabricado Invalido!!!");
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return (cor != null) ? cor.getCor() : null;
    }

    public void setCor(Cor cor) {
        if (cor == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cor Invalido!!!");
        this.cor = cor;
    }

    public String getMarca() {
        return (marca != null) ? marca.getMarca() : null;
    }

    public void setMarca(Marca marca) {
        if (marca == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca Invalido!!!");
        this.marca = marca;
    }

    public VeiculosEnum getTipoVeiculo() {
        return (tipoVeiculo != null) ? tipoVeiculo.getVeiculo() : null;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        if (tipoVeiculo == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "TipoVeiculo Invalido!!!");
        this.tipoVeiculo = tipoVeiculo;
    }

    public Placa getEmplacamento() {
        return emplacamento;
    }

    public void setEmplacamento(Placa emplacamento) {
        if (emplacamento == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Emplacamento Invalido!!!");
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
