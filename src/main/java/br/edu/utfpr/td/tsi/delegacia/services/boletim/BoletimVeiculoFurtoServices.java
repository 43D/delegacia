package br.edu.utfpr.td.tsi.delegacia.services.boletim;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.delegacia.entity.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.exception.EntidadeInexistenteException;
import br.edu.utfpr.td.tsi.delegacia.repository.BoletimRepository;
import br.edu.utfpr.td.tsi.delegacia.values.boletim.PeriodoOcorrencia;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Cidade;

@Component
public class BoletimVeiculoFurtoServices implements iBoletimServices {
    @Autowired
    BoletimRepository repository;

    @Override
    public List<BoletimFurtoVeiculo> getBoletimPage(int page, String cidade, String periodo) {
        List<BoletimFurtoVeiculo> lista = null;

        if (!cidade.isEmpty() && !periodo.isEmpty())
            lista = getBoletimPagePorCidadePeriodo(page, cidade, periodo);

        else if (!cidade.isEmpty())
            lista = getBoletimPagePorCidade(page, cidade);

        else if (!periodo.isEmpty())
            lista = getBoletimPagePorPeriodo(page, periodo);

        else
            lista = getBoletimPage(page);

        return lista;

    }

    private List<BoletimFurtoVeiculo> getBoletimPage(int page) {
        Pageable pageable = PageRequest.of(page - 1, 50);
        Page<BoletimFurtoVeiculo> boletins = repository.findAll(pageable);
        List<BoletimFurtoVeiculo> boletinsList = boletins.getContent();
        return boletinsList;
    }

    private List<BoletimFurtoVeiculo> getBoletimPagePorCidade(int page, String cidade) {
        Pageable pageable = PageRequest.of(page - 1, 50);
        Cidade cidadeObj = new Cidade(cidade);
        Page<BoletimFurtoVeiculo> lista = repository.findByLocalOcorrenciaCidade(cidadeObj, pageable);

        return lista.getContent();
    }

    private List<BoletimFurtoVeiculo> getBoletimPagePorPeriodo(int page, String periodo) {
        Pageable pageable = PageRequest.of(page - 1, 50);
        PeriodoOcorrencia periodoObj = new PeriodoOcorrencia(periodo);
        Page<BoletimFurtoVeiculo> lista = repository.findByPeriodoOcorrencia(periodoObj, pageable);

        return lista.getContent();
    }

    private List<BoletimFurtoVeiculo> getBoletimPagePorCidadePeriodo(int page, String cidade, String periodo) {
        Pageable pageable = PageRequest.of(page - 1, 50);
        PeriodoOcorrencia periodoObj = new PeriodoOcorrencia(periodo);
        Cidade cidadeObj = new Cidade(cidade);
        Page<BoletimFurtoVeiculo> lista = repository.findByPeriodoOcorrenciaAndLocalOcorrenciaCidade(periodoObj,
                cidadeObj, pageable);

        return lista.getContent();
    }

    @Override
    public BoletimFurtoVeiculo getBoletimById(long id) {
        Optional<BoletimFurtoVeiculo> boletim = repository.findById(id);
        if (boletim.isPresent())
            return boletim.get();
        return null;
    }

    @Override
    public BoletimFurtoVeiculo createBoletimId(BoletimFurtoVeiculo bo) {
        repository.save(bo);
        bo.getVeiculoFurtado().setEnvolvidoEm(bo);
        return bo;
    }

    @Override
    public BoletimFurtoVeiculo updateBoletim(BoletimFurtoVeiculo bo, long id) {
        BoletimFurtoVeiculo boletimAntigo = getBoletimById(id);
        if (boletimAntigo == null)
            throw new EntidadeInexistenteException("Bo não existe!!!");

        bo.setId(boletimAntigo.getId());
        bo.getLocalOcorrencia().setId(boletimAntigo.getLocalOcorrencia().getId());
        bo.getVeiculoFurtado().setId(boletimAntigo.getVeiculoFurtado().getId());
        bo.getVeiculoFurtado().getEmplacamento().setId(boletimAntigo.getVeiculoFurtado().getEmplacamento().getId());

        repository.saveAndFlush(bo);

        return repository.findById(bo.getId()).get();
    }

    @Override
    public void deleteBoletimByID(long id) {
        BoletimFurtoVeiculo bo = getBoletimById(id);
        if (bo == null)
            throw new EntidadeInexistenteException("Bo não existe!!!");
        repository.deleteById(id);
    }

}
