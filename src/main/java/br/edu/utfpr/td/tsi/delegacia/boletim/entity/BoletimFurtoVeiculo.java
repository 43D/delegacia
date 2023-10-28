package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@Table(name = "BoletimFurtoVeiculo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BoletimFurtoVeiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "crime")
    private String crime;
    @Column(name = "dataOcorrencia")
    private Date dataOcorrencia;
    @Column(name = "periodoOcorrencia")
    private Date periodoOcorrencia;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "partes")
    private List<Parte> partes;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Endereco localOcorrencia;
    @OneToOne(cascade = CascadeType.ALL)
    private Veiculo veiculoFurtado;

    public BoletimFurtoVeiculo(long id, String crime, Date dataOcorrencia,
            Date periodoOcorrencia,
            List<Parte> partes,
            Endereco localOcorrencia,
            Veiculo veiculoFurtado) {
        this.id = id;
        this.crime = crime;
        this.dataOcorrencia = dataOcorrencia;
        this.periodoOcorrencia = periodoOcorrencia;
        this.partes = partes;
        this.localOcorrencia = localOcorrencia;
        this.veiculoFurtado = veiculoFurtado;
    }

    public BoletimFurtoVeiculo(long id, String crime) {
        this.id = id;
        this.crime = crime;
        this.dataOcorrencia = null;
        this.periodoOcorrencia = null;
        this.partes = null;
        this.localOcorrencia = null;
        this.veiculoFurtado = null;
    }

    public BoletimFurtoVeiculo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public Date getPeriodoOcorrencia() {
        return periodoOcorrencia;
    }

    public void setPeriodoOcorrencia(Date periodoOcorrencia) {
        this.periodoOcorrencia = periodoOcorrencia;
    }

    public List<Parte> getPartes() {
        return partes;
    }

    public void setPartes(List<Parte> partes) {
        this.partes = partes;
    }

    public void addPartes(Parte parte) {
        this.partes.add(parte);
    }

    public Endereco getLocalOcorrencia() {
        return localOcorrencia;
    }

    public void setLocalOcorrencia(Endereco localOcorrencia) {
        this.localOcorrencia = localOcorrencia;
    }

    public Veiculo getVeiculoFurtado() {
        return veiculoFurtado;
    }

    public void setVeiculoFurtado(Veiculo veiculoFurtado) {
        this.veiculoFurtado = veiculoFurtado;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

}
