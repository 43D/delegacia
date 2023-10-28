package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.PlacaVeiculoValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PlacaConverter implements AttributeConverter<PlacaVeiculoValidator, String> {

    @Override
    public String convertToDatabaseColumn(PlacaVeiculoValidator placa) {
        if (placa == null)
            return null;

        return placa.getPlaca();
    }

    @Override
    public PlacaVeiculoValidator convertToEntityAttribute(String str) {
        try {
            return new PlacaVeiculoValidator(str);
        } catch (Exception e) {
            return null;
        }
    }
}