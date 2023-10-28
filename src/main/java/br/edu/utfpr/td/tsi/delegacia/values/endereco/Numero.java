package br.edu.utfpr.td.tsi.delegacia.values.endereco;

import br.edu.utfpr.td.tsi.delegacia.validator.StringValidator;

public class Numero {
    private String numero;

    
    public Numero(String numero) {
        String str = StringValidator.validateStringWithoutSpace(numero, "numero");
        this.numero = str;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return numero;
    }
}
