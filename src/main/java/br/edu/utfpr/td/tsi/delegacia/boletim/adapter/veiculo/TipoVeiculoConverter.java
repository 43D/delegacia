package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.TipoVeiculoValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoVeiculoConverter implements AttributeConverter<TipoVeiculoValidator, String> {

    @Override
    public String convertToDatabaseColumn(TipoVeiculoValidator tipoVeiculo) {
        if (tipoVeiculo == null)
            return null;

        return tipoVeiculo.toString();
    }

    @Override
    public TipoVeiculoValidator convertToEntityAttribute(String str) {
        try {
            return new TipoVeiculoValidator(str);
        } catch (Exception e) {
            return null;
        }
    }
}
