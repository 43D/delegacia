package br.edu.utfpr.td.tsi.delegacia.services.veiculo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.delegacia.entity.Veiculo;
import br.edu.utfpr.td.tsi.delegacia.exception.EntidadeInexistenteException;
import br.edu.utfpr.td.tsi.delegacia.repository.VeiculoRepository;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.Cor;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.TipoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.values.placa.PlacaVeiculo;

@Component
public class VeiculoServices implements iVeiculoServices {
    @Autowired
    VeiculoRepository repository;

    @Override
    public List<Veiculo> getVeiculoPage(int page, String placa, String cor, String tipo) {
        List<Veiculo> lista = null;
        Pageable pageable = PageRequest.of(page - 1, 50);

        if (!placa.isEmpty())
            lista = getVeiculoByPlaca(pageable, placa);

        else if (!cor.isEmpty() && !tipo.isEmpty())
            lista = getVeiculoByCorAndTipo(pageable, cor, tipo);

        else if (!cor.isEmpty())
            lista = getVeiculoByCor(pageable, cor);

        else if (!tipo.isEmpty())
            lista = getVeiculoByTipo(pageable, tipo);

        else
            lista = getVeiculoPage(pageable);

        return lista;
    }

    private List<Veiculo> getVeiculoPage(Pageable pageable) {
        Page<Veiculo> veiculos = repository.findAll(pageable);
        List<Veiculo> veiculosList = veiculos.getContent();
        return veiculosList;
    }

    private List<Veiculo> getVeiculoByPlaca(Pageable pageable, String placa) {
        PlacaVeiculo placaObj = new PlacaVeiculo(placa);
        Page<Veiculo> lista = repository.findByEmplacamentoPlaca(placaObj, pageable);
        return lista.getContent();
    }

    private List<Veiculo> getVeiculoByCorAndTipo(Pageable pageable, String cor, String tipo) {
        Cor corObj = new Cor(cor);
        TipoVeiculo tipoObj = new TipoVeiculo(tipo);
        Page<Veiculo> lista = repository.findByCorAndTipoVeiculo(corObj, tipoObj, pageable);
        return lista.getContent();
    }

    private List<Veiculo> getVeiculoByCor(Pageable pageable, String cor) {
        Cor corObj = new Cor(cor);
        Page<Veiculo> lista = repository.findByCor(corObj, pageable);
        return lista.getContent();
    }

    private List<Veiculo> getVeiculoByTipo(Pageable pageable, String tipo) {
        TipoVeiculo tipoObj = new TipoVeiculo(tipo);
        Page<Veiculo> lista = repository.findByTipoVeiculo(tipoObj, pageable);
        return lista.getContent();
    }

    @Override
    public Veiculo getVeiculoById(long id) {
        Optional<Veiculo> veiculo = repository.findById(id);

        if (veiculo.isPresent())
            return veiculo.get();

        throw new EntidadeInexistenteException("Bo não existe!!!");
    }

}
