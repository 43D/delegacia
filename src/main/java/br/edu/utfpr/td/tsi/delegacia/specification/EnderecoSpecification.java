package br.edu.utfpr.td.tsi.delegacia.specification;

import br.edu.utfpr.td.tsi.delegacia.entity.Endereco;

public class EnderecoSpecification {
    public static boolean checkEnderecoSpecification(Endereco endereco) {
        if (checkIsNull(endereco.getLogradouro()))
            return false;

        if (checkIsNull(endereco.getNumero()))
            return false;

        if (checkIsNull(endereco.getBairro()))
            return false;

        if (checkIsNull(endereco.getCidade()))
            return false;

        if (checkIsNull(endereco.getEstado()))
            return false;

        return true;
    }
    
    public static Endereco getEnderecoLGPDSpecification(Endereco endereco) {
        return endereco;
    }

    private static boolean checkIsNull(Object obj) {
        return (obj == null) ? true : false;
    }
}


