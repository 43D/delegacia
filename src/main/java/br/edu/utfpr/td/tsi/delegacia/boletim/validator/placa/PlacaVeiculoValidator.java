package br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class PlacaVeiculoValidator {
    private String placa;

    public PlacaVeiculoValidator(String placa) {

        String str = StringValidator.validateStringWithoutSpace(placa, "placa");

        String regex = "[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}|[A-Z]{3}[0-9]{4}";

        if (!StringValidator.validateRegex(regex, str))
            throw new IllegalStateException("Placa Invalida!!!");
        this.placa = str;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return placa;
    }
}
