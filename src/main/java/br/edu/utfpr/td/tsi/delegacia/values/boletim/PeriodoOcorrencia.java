package br.edu.utfpr.td.tsi.delegacia.values.boletim;

import br.edu.utfpr.td.tsi.delegacia.enuns.PeriodosEnum;
import br.edu.utfpr.td.tsi.delegacia.validator.StringValidator;

public class PeriodoOcorrencia {
    private PeriodosEnum periodo;

    
    public PeriodoOcorrencia(String periodo) {
        String str = StringValidator.validateStringWithSpace(periodo, "PeriodoOcorrencia");

        PeriodosEnum p = null;
        if (str.contains(" ")) {
            p = PeriodosEnum.fromDesc(str);
        } else {
            p = PeriodosEnum.valueOf(str);
        }

        if (p == null)
            throw new IllegalStateException("Periodo de Ocorrencia Invalida!!!");

        this.periodo = p;
    }

    public PeriodosEnum getPeriodo() {
        return periodo;
    }

    @Override
    public String toString() {
        return periodo.toString();
    }
}
