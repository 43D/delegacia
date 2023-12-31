package br.edu.utfpr.td.tsi.delegacia.values.Veiculo;

import java.time.Year;

public class AnoFabricado {
    private Integer ano;

    public AnoFabricado(Integer ano) {
        if (ano < 1900 || ano > Year.now().getValue())
            if (ano != 0)
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
