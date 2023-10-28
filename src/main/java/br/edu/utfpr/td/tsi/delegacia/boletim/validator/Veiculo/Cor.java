package br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class Cor {
    private String cor;

    public Cor(String cor) throws Exception {
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
