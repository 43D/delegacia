package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.NomeValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NomeConverter implements AttributeConverter<NomeValidator, String> {

    @Override
    public String convertToDatabaseColumn(NomeValidator nome) {
        if (nome == null)
            return null;
        return nome.toString();
    }

    @Override
    public NomeValidator convertToEntityAttribute(String str) {
        try {
            return new NomeValidator(str);
        } catch (Exception e) {
           return null;
        }
    }
}