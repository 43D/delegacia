package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.EnvolvimentoValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EnvolvimentoConverter implements AttributeConverter<EnvolvimentoValidator, String> {

    @Override
    public String convertToDatabaseColumn(EnvolvimentoValidator envolvidoEm) {
        if (envolvidoEm == null)
            return null;
        return envolvidoEm.toString();
    }

    @Override
    public EnvolvimentoValidator convertToEntityAttribute(String str) {
        try {
            return new EnvolvimentoValidator(str);
        } catch (Exception e) {
            return null;
        }
    }
}