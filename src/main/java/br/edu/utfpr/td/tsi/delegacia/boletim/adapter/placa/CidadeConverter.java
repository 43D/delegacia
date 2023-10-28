package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.Cidade;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CidadeConverter implements AttributeConverter<Cidade, String> {

    @Override
    public String convertToDatabaseColumn(Cidade cidade) {
        if (cidade == null)
            return null;

        return cidade.getCidade();
    }

    @Override
    public Cidade convertToEntityAttribute(String str) {
        try {
            return new Cidade(str);
        } catch (Exception e) {
            return null;
        }
    }
}