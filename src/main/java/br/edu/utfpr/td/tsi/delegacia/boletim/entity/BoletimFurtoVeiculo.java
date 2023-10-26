package br.edu.utfpr.td.tsi.delegacia.boletim.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "BoletimFurtoVeiculo")
public class BoletimFurtoVeiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column( name = "id")
    private long id;
    @Column( name = "crime")
    private String crime;
    @Column( name = "dataOcorrencia")
    private Date dataOcorrencia;
    @Column( name = "periodoOcorrencia")
    private Date periodoOcorrencia;
    @OneToMany
    @Column(name = "partes")
    private ArrayList<Parte> partes;
    @OneToOne
    private Endereco localOcorrencia;
    @ManyToOne
    private Veiculo veiculoFurtado;

    public BoletimFurtoVeiculo(long id, String crime, Date dataOcorrencia,
            Date periodoOcorrencia,
            ArrayList<Parte> partes,
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

    public ArrayList<Parte> getPartes() {
        return partes;
    }

    public void setPartes(ArrayList<Parte> partes) {
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
