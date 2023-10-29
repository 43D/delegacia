package br.edu.utfpr.td.tsi.delegacia.services.boletim;

import java.util.List;

import br.edu.utfpr.td.tsi.delegacia.entity.BoletimFurtoVeiculo;

public interface iBoletimServices {
    public List<BoletimFurtoVeiculo> getBoletimPage(int page, String cidade, String periodo);
    public BoletimFurtoVeiculo getBoletimById(long id);
    public BoletimFurtoVeiculo createBoletimId(BoletimFurtoVeiculo bo);
    public BoletimFurtoVeiculo updateBoletim(BoletimFurtoVeiculo bo, long id);
    public void deleteBoletimByID(long id);
}
