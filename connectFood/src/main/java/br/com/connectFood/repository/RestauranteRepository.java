package br.com.connectFood.repository;

import br.com.connectFood.model.RestauranteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<RestauranteModel, Integer> {

    List<RestauranteModel> findByNomeRestaurante(String nome);
    RestauranteModel findByCnpj(String nome);


}
