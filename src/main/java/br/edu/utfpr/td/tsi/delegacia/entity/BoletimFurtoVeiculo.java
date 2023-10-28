package br.edu.utfpr.td.tsi.delegacia.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.utfpr.td.tsi.delegacia.adapter.boletim.DataOcorrenciaConverter;
import br.edu.utfpr.td.tsi.delegacia.adapter.boletim.PeriodoConverter;
import br.edu.utfpr.td.tsi.delegacia.values.boletim.DataOcorrencia;
import br.edu.utfpr.td.tsi.delegacia.values.boletim.PeriodoOcorrencia;
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
@Table(name = "BoletimFurtoVeiculo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BoletimFurtoVeiculo implements Serializable {

    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private long id;
    @Column(name = "crime")
    private String crime = "Furto (art. 155) - VEICULO";
    @Column(name = "dataOcorrencia")
    @Convert(converter = DataOcorrenciaConverter.class)
    private DataOcorrencia dataOcorrencia;
    @Column(name = "periodoOcorrencia")
    @Convert(converter = PeriodoConverter.class)
    private PeriodoOcorrencia periodoOcorrencia;
    @Column(name = "flagrante")
    private boolean flagrante;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "partes")
    private List<Parte> partes;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Endereco localOcorrencia;
    @OneToOne(cascade = CascadeType.ALL)
    private Veiculo veiculoFurtado;

    public BoletimFurtoVeiculo(String numeroBO, boolean flagrante, DataOcorrencia dataOcorrencia,
            PeriodoOcorrencia periodoOcorrencia, List<Parte> partes, Endereco localOcorrencia, Veiculo veiculoFurtado) {
        this.flagrante = flagrante;
        this.dataOcorrencia = dataOcorrencia;
        this.periodoOcorrencia = periodoOcorrencia;
        this.partes = partes;
        this.localOcorrencia = localOcorrencia;
        this.veiculoFurtado = veiculoFurtado;
    }

    public BoletimFurtoVeiculo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = "Furto (art. 155) - VEICULO";
    }

    public String getDataOcorrencia() {
        if (this.dataOcorrencia != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = formatter.format(this.dataOcorrencia.getData());
            return strDate;
        }
        return null;
    }

    public void setDataOcorrencia(DataOcorrencia dataOcorrencia) {
        if (dataOcorrencia == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "dataOcorrencia Invalida!!!");
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getPeriodoOcorrencia() {
        return (this.periodoOcorrencia != null) ? periodoOcorrencia.getPeriodo().toString() : null;
    }

    public void setPeriodoOcorrencia(PeriodoOcorrencia periodoOcorrencia) {
        if (periodoOcorrencia == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "periodoOcorrencia Invalida!!!");
        this.periodoOcorrencia = periodoOcorrencia;
    }

    public boolean isFlagrante() {
        return flagrante;
    }

    public void setFlagrante(boolean flagrante) {
        this.flagrante = flagrante;
    }

    public List<Parte> getPartes() {
        return partes;
    }

    public void setPartes(List<Parte> partes) {
        if (partes == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Partes Invalido!!!");
        this.partes = partes;
    }

    public void addPartes(Parte parte) {
        this.partes.add(parte);
    }

    public Endereco getLocalOcorrencia() {
        return localOcorrencia;
    }

    public void setLocalOcorrencia(Endereco localOcorrencia) {
        if (localOcorrencia == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "localOcorrencia Invalida!!!");
        this.localOcorrencia = localOcorrencia;
    }

    public Veiculo getVeiculoFurtado() {
        return veiculoFurtado;
    }

    public void setVeiculoFurtado(Veiculo veiculoFurtado) {
        if (veiculoFurtado == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "veiculoFurtado Invalido!!!");
        this.veiculoFurtado = veiculoFurtado;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", flagrante: " + flagrante + ", crime: "
                + crime + ", dataOcorrencia: " + dataOcorrencia + ", periodoOcorrencia: " + periodoOcorrencia
                + ", partes: " + partes + ", localOcorrencia: " + localOcorrencia + ", veiculoFurtado: "
                + veiculoFurtado + "}";
    }

}
