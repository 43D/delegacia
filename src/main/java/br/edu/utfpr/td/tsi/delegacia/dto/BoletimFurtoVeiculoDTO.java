package br.edu.utfpr.td.tsi.delegacia.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import br.edu.utfpr.td.tsi.delegacia.entity.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.values.boletim.DataOcorrencia;
import br.edu.utfpr.td.tsi.delegacia.values.boletim.PeriodoOcorrencia;

public class BoletimFurtoVeiculoDTO implements Serializable {

    private long id;
    private String crime;
    private DataOcorrencia dataOcorrencia;
    private PeriodoOcorrencia periodoOcorrencia;
    private boolean flagrante;
    private String partes = null;
    private EnderecoDTO localOcorrencia;
    private VeiculoDTO veiculoFurtado;

    public BoletimFurtoVeiculoDTO(BoletimFurtoVeiculo boletim) {
        this.id = boletim.getId();
        this.crime = boletim.getCrime();
        this.dataOcorrencia = boletim.getDataOcorrencia();
        this.periodoOcorrencia = boletim.getPeriodoOcorrencia();
        this.flagrante = boletim.isFlagrante();
        this.localOcorrencia = new EnderecoDTO(boletim.getLocalOcorrencia());
        this.veiculoFurtado = new VeiculoDTO(boletim.getVeiculoFurtado());
    }

    public BoletimFurtoVeiculoDTO(long id, String crime) {
        this.id = id;
        this.crime = crime;
    }

    public long getId() {
        return id;
    }

    public String getCrime() {
        return crime;
    }

    public String getDataOcorrencia() {
        if (this.dataOcorrencia != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = formatter.format(this.dataOcorrencia.getData());
            return strDate;
        }
        return null;
    }

    public String getPeriodoOcorrencia() {
        return (periodoOcorrencia != null) ? periodoOcorrencia.toString() : null;
    }

    public boolean isFlagrante() {
        return flagrante;
    }

    public String getPartes() {
        return partes;
    }

    public EnderecoDTO getLocalOcorrencia() {
        return localOcorrencia;
    }

    public VeiculoDTO getVeiculoFurtado() {
        return veiculoFurtado;
    }

}
