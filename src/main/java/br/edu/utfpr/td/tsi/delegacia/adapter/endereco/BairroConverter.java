package br.edu.utfpr.td.tsi.delegacia.adapter.endereco;

import br.edu.utfpr.td.tsi.delegacia.values.endereco.Bairro;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BairroConverter implements AttributeConverter<Bairro, String> {

    @Override
    public String convertToDatabaseColumn(Bairro bairro) {
        if (bairro == null)
            return null;
        return bairro.getBairro();
    }

    @Override
    public Bairro convertToEntityAttribute(String str) {
        try {
            return new Bairro(str);
        } catch (Exception e) {
           return null;
        }
    }
}