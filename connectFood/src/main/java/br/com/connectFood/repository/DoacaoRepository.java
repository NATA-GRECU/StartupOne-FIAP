package br.com.connectFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.connectFood.model.DoacaoModel;

public interface DoacaoRepository extends JpaRepository<DoacaoModel, Integer> {

    List<DoacaoModel> findByRestaurante_NomeRestaurante(String NomeRestaurante);

    List<DoacaoModel> findByInstituicao_NomeInstituicao(String NomeInstituicao);

}