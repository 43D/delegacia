package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;

import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.endereco.BairroConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.endereco.LogradouroConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.endereco.NumeroConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa.CidadeConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa.EstadoConverter;
import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.UnidadeFederacao;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.Cidade;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "logradouro")
    @Convert(converter = LogradouroConverter.class)
    private String logradouro;
    @Column(name = "numero")
    @Convert(converter = NumeroConverter.class)
    private int numero;
    @Column(name = "bairro")
    @Convert(converter = BairroConverter.class)
    private String bairro;
    @Column(name = "cidade")
    @Convert(converter = CidadeConverter.class)
    private Cidade cidade;
    @Column(name = "estado")
    @Convert(converter = EstadoConverter.class)
    private Estado estado;

    public Endereco(long id, String logradouro, int numero, String bairro, Cidade cidade, Estado estado) {
        this.id = id;
        this.logradouro = logradouro; //
        this.numero = numero; //
        this.bairro = bairro; // 
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade.getCidade();
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederacao getEstado() {
        return estado.getEstado();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
