package br.edu.utfpr.td.tsi.delegacia.values.Veiculo;

import br.edu.utfpr.td.tsi.delegacia.validator.StringValidator;

public class Cor {
    private String cor;

    
    public Cor(String cor) {
        String str = StringValidator.validateStringWithSpace(cor, "cor");
        this.cor = str;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return cor;
    }
}
