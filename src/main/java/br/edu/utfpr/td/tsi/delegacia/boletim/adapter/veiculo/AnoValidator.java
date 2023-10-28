package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.AnoFabricado;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AnoValidator implements AttributeConverter<AnoFabricado, Short> {

    @Override
    public Short convertToDatabaseColumn(AnoFabricado ano) {
        return ano.getAno();
    }

    @Override
    public AnoFabricado convertToEntityAttribute(Short str) {
        try {
            return new AnoFabricado(str);
        } catch (Exception e) {
            return null;
        }
    }
}
