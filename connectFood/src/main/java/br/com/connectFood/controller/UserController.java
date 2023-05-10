package br.com.connectFood.controller;

import br.com.connectFood.model.UserModel;
import br.com.connectFood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //TODO Criar lógica de login
    //TODO Criar Services para chamar métodos de salvar, editar etc

    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody UserModel userModel) {
        userRepository.save(userModel);
        return ResponseEntity.ok(userModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") int id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editUser(@PathVariable(value = "id") int id,
                                           @RequestBody UserModel user) {
        user.setId(id);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable(value = "id") int id) {
        Optional<UserModel> instituicaoModelOptional = userRepository.findById(id);
        return ResponseEntity.ok(instituicaoModelOptional);
    }

    @GetMapping("/cnpj/{cnpj}")
    public UserModel getByCnpj(@PathVariable(value = "cnpj") String cnpj)
    {
        return userRepository.findByCnpj(cnpj);
    }

}
