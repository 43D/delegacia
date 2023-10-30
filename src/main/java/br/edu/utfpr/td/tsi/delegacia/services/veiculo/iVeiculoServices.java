package br.edu.utfpr.td.tsi.delegacia.services.veiculo;

import java.util.List;

import br.edu.utfpr.td.tsi.delegacia.entity.Veiculo;

public interface iVeiculoServices {
    public List<Veiculo> getVeiculoPage(int page, String placa, String cor, String tipo);
    public Veiculo getVeiculoById(long id);
}
