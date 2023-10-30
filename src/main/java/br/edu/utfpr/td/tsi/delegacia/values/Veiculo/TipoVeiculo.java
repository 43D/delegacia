package br.edu.utfpr.td.tsi.delegacia.values.Veiculo;

import br.edu.utfpr.td.tsi.delegacia.enuns.VeiculosEnum;
import br.edu.utfpr.td.tsi.delegacia.validator.StringValidator;

public class TipoVeiculo {
    private VeiculosEnum veiculo;

    
    public TipoVeiculo(String veiculo) {
        String str = StringValidator.validateStringWithUnderline(veiculo, "veiculo");
        VeiculosEnum veicEnum = VeiculosEnum.valueOf(str);
        this.veiculo = veicEnum;
    }

    public VeiculosEnum getVeiculo() {
        return veiculo;
    }

    @Override
    public String toString() {
        return veiculo.toString();
    }
}
