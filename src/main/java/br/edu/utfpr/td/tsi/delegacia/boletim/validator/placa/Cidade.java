package br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa;

public class Cidade {

    private String cidade;

    public Cidade(String cidade) throws Exception {

        String str = cidade.replaceAll("[^a-zA-Z0-9]", "");
        str = str.trim();
        str = str.toUpperCase();
        if (str.isEmpty() || str == null)
            throw new IllegalStateException("Cidade Invalido!!!");
        this.cidade = str;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return cidade;
    }
}
