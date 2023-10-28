package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.EstadoValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstadoConverter implements AttributeConverter<EstadoValidator, String> {

    @Override
    public String convertToDatabaseColumn(EstadoValidator uf) {
        if (uf == null)
            return null;

        return uf.toString();
    }

    @Override
    public EstadoValidator convertToEntityAttribute(String str) {
        try {
            return new EstadoValidator(str);
        } catch (Exception e) {
            return null;
        }
    }
}
