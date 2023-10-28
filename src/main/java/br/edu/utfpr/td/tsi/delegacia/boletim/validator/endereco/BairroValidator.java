package br.edu.utfpr.td.tsi.delegacia.boletim.validator.endereco;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class BairroValidator {
    private String email;

    public BairroValidator(String email) {
        String str = StringValidator.validateString(email, "email");

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";

        if (!StringValidator.validateRegex(regex, str))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email Invalida!!!");

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
