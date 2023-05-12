package br.com.connectFood.services;

import br.com.connectFood.enums.UserTypeEnum;
import br.com.connectFood.model.UserLoginModel;
import br.com.connectFood.model.UserModel;
import br.com.connectFood.repository.UserRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public Optional<UserModel> registerUser(UserModel userModel)
    {
        if(Objects.nonNull(userRepository.findByEmail(userModel.getEmail())))
        {
            return null;
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(userModel.getPassword());
        userModel.setPassword(senhaEncoder);

        return Optional.of(userRepository.save(userModel));
    }

    public Optional<UserLoginModel> login(Optional<UserLoginModel> user)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<UserModel> usuario = Optional.ofNullable(userRepository.findByEmail(user.get().getEmail()));

        if(usuario.isPresent())
        {
            if(encoder.matches(user.get().getPassword(), usuario.get().getPassword()))
            {
                String auth = user.get().getEmail() + ":" + user.get().getPassword();
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);

                user.get().setToken(authHeader);
                user.get().setId(usuario.get().getId());
                user.get().setNome(usuario.get().getName());
                user.get().setPhoto(usuario.get().getPhoto());
                user.get().setType(usuario.get().getType());

                return user;
            }
        }

        return null;
    }

    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }

    public Optional<UserModel> editUser(int id, UserModel userModel)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(userModel.getPassword());
        userModel.setPassword(senhaEncoder);

        return Optional.of(userRepository.save(userModel));
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
