package br.edu.utfpr.td.tsi.delegacia.specification;

import br.edu.utfpr.td.tsi.delegacia.entity.Placa;

public class PlacaSpecification {
    public static boolean checkPlacaSpecification(Placa placa) {
        if (checkIsNull(placa.getPlaca()))
            return false;

        if (checkIsNull(placa.getCidade()))
            return false;

        if (checkIsNull(placa.getEstado()))
            return false;

        return true;
    }

    public static Placa getPlacaLGPDSpecification(Placa placa) {
        return placa;
    }

    private static boolean checkIsNull(Object obj) {
        return (obj == null) ? true : false;
    }
}
