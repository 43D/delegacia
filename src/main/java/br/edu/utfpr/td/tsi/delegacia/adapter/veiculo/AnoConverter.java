package br.edu.utfpr.td.tsi.delegacia.adapter.veiculo;

import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.AnoFabricado;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AnoConverter implements AttributeConverter<AnoFabricado, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AnoFabricado ano) {
        return ano.getAno();
    }

    @Override
    public AnoFabricado convertToEntityAttribute(Integer str) {
        try {
            return new AnoFabricado(str);
        } catch (Exception e) {
            return null;
        }
    }
}
