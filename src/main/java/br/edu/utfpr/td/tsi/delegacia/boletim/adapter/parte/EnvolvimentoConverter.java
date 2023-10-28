package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.EnvolvimentoParte;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EnvolvimentoConverter implements AttributeConverter<EnvolvimentoParte, String> {

    @Override
    public String convertToDatabaseColumn(EnvolvimentoParte envolvidoEm) {
        if (envolvidoEm == null)
            return null;
        return envolvidoEm.toString();
    }

    @Override
    public EnvolvimentoParte convertToEntityAttribute(String str) {
        try {
            return new EnvolvimentoParte(str);
        } catch (Exception e) {
            return null;
        }
    }
}