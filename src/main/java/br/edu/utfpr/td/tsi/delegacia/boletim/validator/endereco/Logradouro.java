package br.edu.utfpr.td.tsi.delegacia.boletim.validator.endereco;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class Logradouro {
    private String logradouro;

    public Logradouro(String logradouro) {
        String str = StringValidator.validateStringWithSpace(logradouro, "Logradouro");
        this.logradouro = str;
    }

    public String getLogradouro() {
        return logradouro;
    }

    @Override
    public String toString() {
        return logradouro;
    }
}
