package br.edu.utfpr.td.tsi.delegacia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.td.tsi.delegacia.entity.Veiculo;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.Cor;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.TipoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.values.placa.PlacaVeiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Page<Veiculo> findByEmplacamentoPlaca(PlacaVeiculo emplacamento, Pageable pageable);

    Page<Veiculo> findByCorAndTipoVeiculo(Cor cor, TipoVeiculo tipoVeiculo, Pageable pageable);

    Page<Veiculo> findByCor(Cor cor, Pageable pageable);

    Page<Veiculo> findByTipoVeiculo(TipoVeiculo tipoVeiculo, Pageable pageable);

}
