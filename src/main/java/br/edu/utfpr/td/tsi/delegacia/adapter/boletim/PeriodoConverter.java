package br.edu.utfpr.td.tsi.delegacia.adapter.boletim;

import br.edu.utfpr.td.tsi.delegacia.values.boletim.PeriodoOcorrencia;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PeriodoConverter implements AttributeConverter<PeriodoOcorrencia, String> {

    @Override
    public String convertToDatabaseColumn(PeriodoOcorrencia periodo) {
        if (periodo == null)
            return null;
            
        return periodo.getPeriodo().toString();
    }

    @Override
    public PeriodoOcorrencia convertToEntityAttribute(String str) {
        try {
            return new PeriodoOcorrencia(str);
        } catch (Exception e) {
           return null;
        }
    }
}