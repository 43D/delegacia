package br.edu.utfpr.td.tsi.delegacia.boletim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.td.tsi.delegacia.boletim.entity.BoletimFurtoVeiculo;

public interface BoletimRepository extends JpaRepository<BoletimFurtoVeiculo, Long>{
}
