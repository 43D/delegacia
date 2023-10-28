package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.AnoFabricadoValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AnoConverter implements AttributeConverter<AnoFabricadoValidator, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AnoFabricadoValidator ano) {
        return ano.getAno();
    }

    @Override
    public AnoFabricadoValidator convertToEntityAttribute(Integer str) {
        try {
            return new AnoFabricadoValidator(str);
        } catch (Exception e) {
            return null;
        }
    }
}
