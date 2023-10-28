package br.edu.utfpr.td.tsi.delegacia.specification;

import java.util.List;

import br.edu.utfpr.td.tsi.delegacia.entity.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.entity.Parte;

public class BoletimFurtoVeiculoSpecification {
    public static boolean checkBoletimFurtoVeiculoSpecification(BoletimFurtoVeiculo bo) {
        if (checkIsNull(bo.getDataOcorrencia()))
            return false;
        if (checkIsNull(bo.getPeriodoOcorrencia()))
            return false;

        if (checkListIsNull(bo.getPartes()))
            return false;

        if (bo.getPartes().isEmpty())
            return false;

        if (checkIsNull(bo.getLocalOcorrencia()))
            return false;

        if (!EnderecoSpecification.checkEnderecoSpecification(bo.getLocalOcorrencia()))
            return false;

        if (checkIsNull(bo.getVeiculoFurtado()))
            return false;

        if (!VeiculoSpecification.checkVeiculoSpecification(bo.getVeiculoFurtado()))
            return false;

        return true;
    }

    public static BoletimFurtoVeiculo getBoletimFurtoVeiculoLGPDSpecification(BoletimFurtoVeiculo bo) {

        return bo;
    }

    private static boolean checkIsNull(Object obj) {
        return (obj == null) ? true : false;
    }

    private static boolean checkListIsNull(List<Parte> list) {
        if (checkIsNull(list))
            return true;
        for (Parte o : list) {
            if (checkIsNull(o))
                return true;
            if (!ParteSpecification.checkParteSpecification(o))
                return true;
        }

        return false;
    }
}
