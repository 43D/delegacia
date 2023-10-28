package br.edu.utfpr.td.tsi.delegacia.adapter.parte;

import br.edu.utfpr.td.tsi.delegacia.values.parte.NomeParte;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NomeConverter implements AttributeConverter<NomeParte, String> {

    @Override
    public String convertToDatabaseColumn(NomeParte nome) {
        if (nome == null)
            return null;
        return nome.getNome();
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