package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo.MarcaValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MarcaConverter implements AttributeConverter<MarcaValidator, String> {

    @Override
    public String convertToDatabaseColumn(MarcaValidator marca) {
        if (marca == null)
            return null;

        return marca.getMarca();
    }

    @Override
    public MarcaValidator convertToEntityAttribute(String str) {
        try {
            return new MarcaValidator(str);
        } catch (Exception e) {
            return null;
        }
    }
}
