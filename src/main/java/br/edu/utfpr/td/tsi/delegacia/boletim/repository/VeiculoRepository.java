package br.edu.utfpr.td.tsi.delegacia.boletim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.td.tsi.delegacia.boletim.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
}
