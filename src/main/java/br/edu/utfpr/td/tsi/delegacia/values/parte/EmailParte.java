package br.edu.utfpr.td.tsi.delegacia.values.parte;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.edu.utfpr.td.tsi.delegacia.validator.StringValidator;

public class EmailParte {
    private String email;


    public EmailParte(String email) {
        String str = StringValidator.validateString(email, "email");

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";

        if (!StringValidator.validateRegex(regex, str))
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Email Invalida!!!");

        this.email = str;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return email;
    }
}
