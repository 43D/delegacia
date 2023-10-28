package br.edu.utfpr.td.tsi.delegacia.boletim.validator.parte;

import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class EnvolvimentoValidator {
    private String envolvimento;

    public EnvolvimentoValidator(String envolvimento) {
        String str = StringValidator.validateString(envolvimento, "envolvimento");
        this.envolvimento = str;
    }

    public String getEnvolvimento() {
        return envolvimento;
    }

    @Override
    public String toString() {
        return envolvimento;
    }
}
