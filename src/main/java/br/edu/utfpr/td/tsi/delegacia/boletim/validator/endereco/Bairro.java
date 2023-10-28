package br.edu.utfpr.td.tsi.delegacia.boletim.validator.endereco;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class Bairro {
    private String bairro;

    public Bairro(String bairro) {
        String str = StringValidator.validateStringWithSpace(bairro, "Bairro");
        this.bairro = str;
    }

    public String getBairro() {
        return bairro;
    }

    @Override
    public String toString() {
        return bairro;
    }
}
