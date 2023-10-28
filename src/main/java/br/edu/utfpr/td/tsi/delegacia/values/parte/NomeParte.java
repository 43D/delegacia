package br.edu.utfpr.td.tsi.delegacia.values.parte;

import br.edu.utfpr.td.tsi.delegacia.values.StringValidator;

public class NomeParte {
    private String nome;

    public NomeParte(String nome) {
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
