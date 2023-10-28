package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.placa;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa.PlacaVeiculo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PlacaConverter implements AttributeConverter<PlacaVeiculo, String> {

    @Override
    public String convertToDatabaseColumn(PlacaVeiculo placa) {
        if (placa == null)
            return null;

        return placa.getPlaca();
    }

    @Override
    public PlacaVeiculo convertToEntityAttribute(String str) {
        try {
            return new PlacaVeiculo(str);
        } catch (Exception e) {
            return null;
        }
    }
}