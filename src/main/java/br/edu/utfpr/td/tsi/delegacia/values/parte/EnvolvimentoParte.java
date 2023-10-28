package br.edu.utfpr.td.tsi.delegacia.values.parte;

import br.edu.utfpr.td.tsi.delegacia.validator.StringValidator;

public class EnvolvimentoParte {
    private String envolvimento;

    
    public EnvolvimentoParte(String envolvimento) {
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
