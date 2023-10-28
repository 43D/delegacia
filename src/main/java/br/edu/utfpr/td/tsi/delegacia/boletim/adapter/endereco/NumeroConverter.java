package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.endereco;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.endereco.Numero;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NumeroConverter implements AttributeConverter<Numero, String> {

    @Override
    public String convertToDatabaseColumn(Numero numero) {
        if (numero == null)
            return null;
        return numero.getNumero();
    }

    @Override
    public Numero convertToEntityAttribute(String str) {
        try {
            return new Numero(str);
        } catch (Exception e) {
           return null;
        }
    }
}