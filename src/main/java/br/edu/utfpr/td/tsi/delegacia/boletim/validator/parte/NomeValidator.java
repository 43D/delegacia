package br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class NomeValidator {
    private String nome;

    public NomeValidator(String nome) {
        String str = StringValidator.validateStringWithSpace(nome, "nome");
        this.nome = str;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
