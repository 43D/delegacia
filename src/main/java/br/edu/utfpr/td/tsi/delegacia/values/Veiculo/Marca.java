package br.edu.utfpr.td.tsi.delegacia.values.Veiculo;

import br.edu.utfpr.td.tsi.delegacia.validator.StringValidator;

public class Marca {
    private String marca;

    
    public Marca(String marca) {
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
