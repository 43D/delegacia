package br.edu.utfpr.td.tsi.delegacia.specification;


import br.edu.utfpr.td.tsi.delegacia.entity.BoletimFurtoVeiculo;

public class BoletimFurtoVeiculoSpecification {
    public static boolean checkBoletimFurtoVeiculoSpecification(BoletimFurtoVeiculo bo) {
        if (checkIsNull(bo.getDataOcorrencia()))
            return false;
        if (checkIsNull(bo.getPeriodoOcorrencia()))
            return false;

        if (checkIsNull(bo.getPartes()))
            return false;

        if (checkIsNull(bo.getLocalOcorrencia()))
            return false;

        if (checkIsNull(bo.getVeiculoFurtado()))
            return false;

        return true;
    }

    public static BoletimFurtoVeiculo getBoletimFurtoVeiculoLGPDSpecification(BoletimFurtoVeiculo bo) {

        return bo;
    }

    private static boolean checkIsNull(Object obj) {
        return (obj == null) ? true : false;
    }
}
