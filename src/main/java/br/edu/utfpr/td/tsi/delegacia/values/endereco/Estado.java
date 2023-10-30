package br.edu.utfpr.td.tsi.delegacia.values.endereco;

import br.edu.utfpr.td.tsi.delegacia.enuns.UnidadeFederacao;
import br.edu.utfpr.td.tsi.delegacia.validator.StringValidator;

public class Estado {
    private UnidadeFederacao estado;

    public Estado(String estado) {
        estado = estado.replaceAll("á", "A");
        estado = estado.replaceAll("Á", "A");
        estado = estado.replaceAll("ã", "A");
        estado = estado.replaceAll("Ã", "A");
        estado = estado.replaceAll("ô", "O");
        estado = estado.replaceAll("Ô", "O");
        estado = estado.replaceAll("í", "I");
        estado = estado.replaceAll("Í", "I");

        String str = StringValidator.validateStringWithUnderline(estado, "Estado");

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
