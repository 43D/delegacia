package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.endereco;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.endereco.Logradouro;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LogradouroConverter implements AttributeConverter<Logradouro, String> {

    @Override
    public String convertToDatabaseColumn(Logradouro logradouro) {
        if (logradouro == null)
            return null;
        return logradouro.getLogradouro();
    }

    @Override
    public Logradouro convertToEntityAttribute(String str) {
        try {
            return new Logradouro(str);
        } catch (Exception e) {
           return null;
        }
    }
}