package br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class MarcaValidator {
    private String marca;

    public MarcaValidator(String marca) throws Exception {
        String str = StringValidator.validateStringWithSpace(marca, "marca");
        this.marca = str;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return marca;
    }
}
