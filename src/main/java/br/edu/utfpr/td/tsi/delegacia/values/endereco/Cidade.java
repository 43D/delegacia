package br.edu.utfpr.td.tsi.delegacia.values.endereco;

import br.edu.utfpr.td.tsi.delegacia.values.StringValidator;

public class Cidade {

    private String cidade;

    public Cidade(String cidade) {
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
