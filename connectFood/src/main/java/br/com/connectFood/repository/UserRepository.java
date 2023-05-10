package br.com.connectFood.repository;

import br.com.connectFood.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    List<UserModel> findAllByName(String name);
    UserModel findByCnpj(String cnpj);
    UserModel findByEmail(String email);
    List<UserModel> findAllByType(String type);

}
