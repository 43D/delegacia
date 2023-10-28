package br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class CidadeValidator {

    private String cidade;

    public CidadeValidator(String cidade) {
        String str = StringValidator.validateStringWithSpace(cidade, "cidade");
        this.cidade = str;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return cidade;
    }
}
