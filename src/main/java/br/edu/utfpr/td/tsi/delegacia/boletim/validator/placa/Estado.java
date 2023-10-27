package br.edu.utfpr.td.tsi.delegacia.boletim.validator.placa;

import br.edu.utfpr.td.tsi.delegacia.boletim.enuns.UnidadeFederacao;
import br.edu.utfpr.td.tsi.delegacia.boletim.validator.StringValidator;

public class Estado {
    private UnidadeFederacao estado;

    public Estado(String estado) throws Exception {
        String str = StringValidator.validateString(estado, "Estado");

        UnidadeFederacao uf = null;
        if (str.length() == 2) {
            uf = UnidadeFederacao.fromSigla(str);
        } else {
            uf = UnidadeFederacao.valueOf(str);
        }

        if (uf == null)
            throw new IllegalStateException("Estado Invalido!!!");

        this.estado = uf;
    }

    public UnidadeFederacao getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return estado.toString();
    }
}
