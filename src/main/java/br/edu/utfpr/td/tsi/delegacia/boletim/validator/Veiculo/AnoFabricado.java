package br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo;

import java.time.Year;

public class AnoFabricado {
    private short ano;

    public AnoFabricado(short ano) throws Exception {
        if (ano < 1900 || ano > Year.now().getValue())
            throw new IllegalStateException("Ano de fabricação Invalida!!!");
        this.ano = ano;
    }

    public short getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "" + ano;
    }
}
