package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.EmailParte;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<EmailParte, String> {

    @Override
    public String convertToDatabaseColumn(EmailParte email) {
        if (email == null)
            return null;
        return email.getEmail();
    }

    @Override
    public EmailParte convertToEntityAttribute(String str) {
        try {
            return new EmailParte(str);
        } catch (Exception e) {
           return null;
        }
    }
}