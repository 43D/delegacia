package br.edu.utfpr.td.tsi.delegacia.adapter.boletim;

import java.util.Date;

import br.edu.utfpr.td.tsi.delegacia.values.boletim.DataOcorrencia;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DataOcorrenciaConverter implements AttributeConverter<DataOcorrencia, Date> {

    @Override
    public Date convertToDatabaseColumn(DataOcorrencia data) {
        if (data == null)
            return null;
        return data.getData();
    }

    @Override
    public DataOcorrencia convertToEntityAttribute(Date data) {
        try {
            return new DataOcorrencia(data);
        } catch (Exception e) {
            return null;
        }
    }
}