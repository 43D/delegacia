package br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class TelefoneParte {
    private String telefone;

    public TelefoneParte(String telefone) {
        String str = StringValidator.validateStringWithoutSpace(telefone, "telefone");

        String regex = "[0-9]{2}[0-9]{1}[0-9]{8}|[0-9]{2}[0-9]{8}";

        if (!StringValidator.validateRegex(regex, str))
            throw new IllegalStateException("telefone Invalida!!!");
        this.telefone = str;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return telefone;
    }
}
