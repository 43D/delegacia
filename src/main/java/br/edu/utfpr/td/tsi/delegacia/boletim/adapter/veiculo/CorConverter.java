package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.CorValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CorConverter implements AttributeConverter<CorValidator, String> {

    @Override
    public String convertToDatabaseColumn(CorValidator cor) {
        if (cor == null)
            return null;

        return cor.getCor();
    }

    @Override
    public CorValidator convertToEntityAttribute(String str) {
        try {
            return new CorValidator(str);
        } catch (Exception e) {
            return null;
        }
    }
}
