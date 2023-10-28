package br.edu.utfpr.td.tsi.delegacia.adapter.placa;

import br.edu.utfpr.td.tsi.delegacia.values.endereco.Estado;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstadoConverter implements AttributeConverter<Estado, String> {

    @Override
    public String convertToDatabaseColumn(Estado uf) {
        if (uf == null)
            return null;

        return uf.toString();
    }

    @Override
    public Estado convertToEntityAttribute(String str) {
        try {
            return new Estado(str);
        } catch (Exception e) {
            return null;
        }
    }
}
