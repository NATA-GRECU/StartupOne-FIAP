package br.com.connectFood.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.connectFood.model.DoacaoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoacaoRepository extends JpaRepository<DoacaoModel, Integer> {

    List<DoacaoModel> findDonationByRestaurante(String restaurante);

    List<DoacaoModel> findDonationByInstituicao(String intituicao);

    List<DoacaoModel> findDonationByDate(Date publicationDate);

    List<DoacaoModel> findDoacaoByDateBetween(Date publicationTimeStart, Date publicationTimeEnd);

}