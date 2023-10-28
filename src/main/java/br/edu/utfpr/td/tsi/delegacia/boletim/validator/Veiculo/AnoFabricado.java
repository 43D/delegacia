package br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo;

import java.time.Year;

public class AnoFabricado {
    private Integer ano;

    public AnoFabricado(Integer ano) {
        if (ano < 1900 || ano > Year.now().getValue())
            throw new IllegalStateException("Ano de fabricação Invalida!!!");
        this.ano = ano;
    }

    public Integer getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "" + ano;
    }
}
