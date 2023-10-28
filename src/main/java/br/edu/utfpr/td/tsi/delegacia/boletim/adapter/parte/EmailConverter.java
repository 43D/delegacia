package br.edu.utfpr.td.tsi.delegacia.boletim.adapter.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte.EmailValidator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<EmailValidator, String> {

    @Override
    public String convertToDatabaseColumn(EmailValidator email) {
        if (email == null)
            return null;
        return email.toString();
    }

    @Override
    public EmailValidator convertToEntityAttribute(String emailString) {
        try {
            return new EmailValidator(emailString);
        } catch (Exception e) {
           return null;
        }
    }
}