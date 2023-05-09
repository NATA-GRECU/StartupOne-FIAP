package br.com.connectFood.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.connectFood.model.DoacaoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoacaoRepository extends JpaRepository<DoacaoModel, Integer> {

    List<DoacaoModel> findByRestaurante_NomeRestaurante(String NomeRestaurante);

    List<DoacaoModel> findByInstituicao_NomeInstituicao(String NomeInstituicao);

    List<DoacaoModel> findAllByDoacaoDate(Date publicationDate);

    List<DoacaoModel> findAllByDoacaoTimeBetween(
            Date publicationTimeStart,
            Date publicationTimeEnd);

    @Query("select a from Article a where a.creationDateTime <= :creationDateTime")
    List<DoacaoModel> findAllWithCreationDateTimeBefore(@Param("creationDateTime") Date creationDateTime);

}