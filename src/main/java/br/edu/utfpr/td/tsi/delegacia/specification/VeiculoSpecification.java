package br.edu.utfpr.td.tsi.delegacia.specification;

import br.edu.utfpr.td.tsi.delegacia.entity.Veiculo;

public class VeiculoSpecification {
    public static boolean checkVeiculoSpecification(Veiculo veiculo) {
        if (checkIsNull(veiculo.getEmplacamento()))
            return false;

        if (!PlacaSpecification.checkPlacaSpecification(veiculo.getEmplacamento()))
            return false;

        if (checkIsNull(veiculo.getAnoFabricacao()))
            return false;

        if (checkIsNull(veiculo.getCor()))
            return false;

        if (checkIsNull(veiculo.getMarca()))
            return false;

        if (checkIsNull(veiculo.getTipoVeiculo()))
            return false;

        return true;
    }

    public static Veiculo getVeiculoLGPDSpecification(Veiculo veiculo) {
        return veiculo;
    }

    private static boolean checkIsNull(Object obj) {
        return (obj == null) ? true : false;
    }

}
