package br.com.connectFood.services;

import br.com.connectFood.enums.UserTypeEnum;
import br.com.connectFood.model.UserModel;
import br.com.connectFood.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public void registeUser(UserModel userModel)
    {
        userRepository.save(userModel);
    }

    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }

    public void editUser(int id, UserModel userModel)
    {
        userModel.setId(id);

        userRepository.save(userModel);
    }

    public List<UserModel> getAllUsers()
    {
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(int id)
    {
        return userRepository.findById(id);
    }

    public UserModel getUserByCnpj(String cnpj)
    {
        return userRepository.findByCnpj(cnpj);
    }

    public List<UserModel> findAllByName(String name)
    {
        return userRepository.findAllByName(name);
    }

    public List<UserModel> findAllByType(UserTypeEnum type)
    {
        return userRepository.findAllByType(type);
    }

    public UserModel findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
}
