package br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class Marca {
    private String marca;

    public Marca(String marca) throws Exception {
        String str = StringValidator.validateString(marca, "marca");
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
