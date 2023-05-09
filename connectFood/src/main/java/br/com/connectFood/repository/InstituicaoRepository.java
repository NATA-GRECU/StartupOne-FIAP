package br.com.connectFood.repository;

import br.com.connectFood.model.InstituicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstituicaoRepository extends JpaRepository<InstituicaoModel, Integer> {

    List<InstituicaoModel> findByNomeInstituicao(String nome);
    InstituicaoModel findByCnpj(String cnpj);


}
