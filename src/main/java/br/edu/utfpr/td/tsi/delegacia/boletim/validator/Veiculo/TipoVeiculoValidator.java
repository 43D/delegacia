package br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.VeiculosEnum;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class TipoVeiculoValidator {
    private VeiculosEnum veiculo;

    public TipoVeiculoValidator(String veiculo) {
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
