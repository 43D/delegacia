package br.edu.utfpr.td.tsi.delegacia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.td.tsi.delegacia.entity.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.values.boletim.PeriodoOcorrencia;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Cidade;

public interface BoletimRepository extends JpaRepository<BoletimFurtoVeiculo, Long> {

    Page<BoletimFurtoVeiculo> findByPeriodoOcorrenciaAndLocalOcorrenciaCidade(PeriodoOcorrencia periodoOcorrencia,
            Cidade cidade, Pageable pageable);

    Page<BoletimFurtoVeiculo> findByLocalOcorrenciaCidade(Cidade cidade, Pageable pageable);

    Page<BoletimFurtoVeiculo> findByPeriodoOcorrencia(PeriodoOcorrencia periodoOcorrencia, Pageable pageable);

}
