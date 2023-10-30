package br.edu.utfpr.td.tsi.delegacia.dto;

import java.io.Serializable;

import br.edu.utfpr.td.tsi.delegacia.entity.Endereco;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Cidade;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Estado;

public class EnderecoDTO implements Serializable {

    // private Logradouro logradouro;
    // private Numero numero;
    // private Bairro bairro;
    private Cidade cidade;
    private Estado estado;

    public EnderecoDTO(Endereco endereco) {
        // this.logradouro = endereco.getLogradouro();
        // this.numero = endereco.getNumero();
        // this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }

    public String getLogradouro() {
        return null;
    }

    public String getNumero() {
        return null;
    }

    public String getBairro() {
        return null;
    }

    public String getCidade() {
        return cidade.toString();
    }

    public String getEstado() {
        return estado.getEstado().toString();
    }

}
