package br.edu.utfpr.td.tsi.delegacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.td.tsi.delegacia.entity.BoletimFurtoVeiculo;

public interface BoletimRepository extends JpaRepository<BoletimFurtoVeiculo, Long> {
    
}
