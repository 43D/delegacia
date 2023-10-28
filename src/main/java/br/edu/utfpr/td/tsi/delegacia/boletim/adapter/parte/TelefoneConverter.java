package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.TelefoneValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TelefoneConverter implements AttributeConverter<TelefoneValidator, String> {

    @Override
    public String convertToDatabaseColumn(TelefoneValidator telefone) {
        if (telefone == null)
            return null;
        return telefone.toString();
    }

    @Override
    public TelefoneValidator convertToEntityAttribute(String str) {
        try {
            return new TelefoneValidator(str);
        } catch (Exception e) {
           return null;
        }
    }
}