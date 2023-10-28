package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.TelefoneParte;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TelefoneConverter implements AttributeConverter<TelefoneParte, String> {

    @Override
    public String convertToDatabaseColumn(TelefoneParte telefone) {
        if (telefone == null)
            return null;
        return telefone.toString();
    }

    @Override
    public TelefoneParte convertToEntityAttribute(String str) {
        try {
            return new TelefoneParte(str);
        } catch (Exception e) {
           return null;
        }
    }
}