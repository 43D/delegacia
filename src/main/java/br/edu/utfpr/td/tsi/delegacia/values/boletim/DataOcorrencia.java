package br.edu.utfpr.td.tsi.delegacia.values.boletim;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.edu.utfpr.td.tsi.delegacia.validator.StringValidator;

public class DataOcorrencia {

    private Date data;


    public DataOcorrencia(Date data) {
        Date agora = new Date();
        if (!data.before(agora))
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Data Invalida, você é um viajante do tempo?");

        this.data = data;
    }

    public DataOcorrencia(String data) {
        String regex = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-([0-9]{4})$";

        if(!StringValidator.validateRegex(regex, data))
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Formato da Data de Ocorrencia é Invalida (dd-MM-YYYY)");

        Date dataOcorrencia = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            dataOcorrencia = formato.parse(data);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Data de Ocorrencia Invalida");
        }

        if(dataOcorrencia == null)
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Data de Ocorrencia Invalida");

        Date agora = new Date();
        if (!dataOcorrencia.before(agora))
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Data de Ocorrencia  Invalida, você é um viajante do tempo?");

        this.data = dataOcorrencia;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
