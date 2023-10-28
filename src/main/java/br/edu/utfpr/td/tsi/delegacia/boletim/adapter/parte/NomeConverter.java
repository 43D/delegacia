package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.NomeParte;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NomeConverter implements AttributeConverter<NomeParte, String> {

    @Override
    public String convertToDatabaseColumn(NomeParte nome) {
        if (nome == null)
            return null;
        return nome.toString();
    }

    @Override
    public NomeParte convertToEntityAttribute(String str) {
        try {
            return new NomeParte(str);
        } catch (Exception e) {
           return null;
        }
    }
}