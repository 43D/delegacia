package br.edu.utfpr.td.tsi.delegacia.specification;

import br.edu.utfpr.td.tsi.delegacia.entity.Parte;

public class ParteSpecification {
    public static boolean checkParteSpecification(Parte parte) {
        if (checkIsNull(parte.getNome()))
            return false;

        if (checkIsNull(parte.getEmail()))
            return false;

        if (checkIsNull(parte.getTelefone()))
            return false;

        if (checkIsNull(parte.getTipoEnvolvimento()))
            return false;

        return true;
    }

    public static Parte getParteLGPDSpecification(Parte parte) {
        return parte;
    }

    private static boolean checkIsNull(Object obj) {
        return (obj == null) ? true : false;
    }
}
