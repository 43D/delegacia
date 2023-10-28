package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.CidadeValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CidadeConverter implements AttributeConverter<CidadeValidator, String> {

    @Override
    public String convertToDatabaseColumn(CidadeValidator cidade) {
        if (cidade == null)
            return null;

        return cidade.toString();
    }

    @Override
    public CidadeValidator convertToEntityAttribute(String str) {
        try {
            return new CidadeValidator(str);
        } catch (Exception e) {
            return null;
        }
    }
}