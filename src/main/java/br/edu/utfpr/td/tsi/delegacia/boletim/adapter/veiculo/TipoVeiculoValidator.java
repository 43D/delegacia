package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.TipoVeiculo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoVeiculoValidator implements AttributeConverter<TipoVeiculo, String> {

    @Override
    public String convertToDatabaseColumn(TipoVeiculo tipoVeiculo) {
        if (tipoVeiculo == null)
            return null;

        return tipoVeiculo.toString();
    }

    @Override
    public TipoVeiculo convertToEntityAttribute(String str) {
        try {
            return new TipoVeiculo(str);
        } catch (Exception e) {
            return null;
        }
    }
}
