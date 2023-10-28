package br.edu.utfpr.td.tsi.delegacia.boletim.validator.Veiculo;

import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.VeiculosEnum;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class TipoVeiculo {
    private VeiculosEnum veiculo;

    public TipoVeiculo(String veiculo) throws Exception {
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