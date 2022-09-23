package br.com.connectFood.repository;

import br.com.connectFood.models.RestauranteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<RestauranteModel, Integer> {

    List<RestauranteModel> findByNomeRestaurante(String nome);
    RestauranteModel findByCnpj(String nome);
    List<RestauranteModel> findByEstado(String estado);
    List<RestauranteModel> findByCidade(String cidade);
    List<RestauranteModel> findByBairro(String bairro);

}
