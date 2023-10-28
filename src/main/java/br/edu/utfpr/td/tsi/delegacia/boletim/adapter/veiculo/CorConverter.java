package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.Cor;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CorConverter implements AttributeConverter<Cor, String> {

    @Override
    public String convertToDatabaseColumn(Cor cor) {
        if (cor == null)
            return null;

        return cor.getCor();
    }

    @Override
    public Cor convertToEntityAttribute(String str) {
        try {
            return new Cor(str);
        } catch (Exception e) {
            return null;
        }
    }
}
