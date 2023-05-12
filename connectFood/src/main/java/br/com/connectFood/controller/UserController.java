package br.com.connectFood.controller;

import br.com.connectFood.enums.UserTypeEnum;
import br.com.connectFood.model.UserModel;
import br.com.connectFood.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@Api(tags = "API de Usuários")
public class UserController {

    @Autowired
    UserService userService;

    //TODO Criar lógica de login

    @PostMapping
    @ApiOperation("Cadastrar um usuário")
    public ResponseEntity<Object> registerUser(@RequestBody UserModel userModel)
    {
        getUserService().registeUser(userModel);

        return ResponseEntity.ok().body("Usuário cadastrado com sucesso!");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletar um usuário")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") int id)
    {
        getUserService().deleteUser(id);

        return ResponseEntity.ok().body("O usuário " + id + " foi deletado!");
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualizar um usuário")
    public ResponseEntity<Object> editUser(@PathVariable(value = "id") int id,
                                           @RequestBody UserModel user)
    {
        getUserService().editUser(id, user);

        return ResponseEntity.ok().body("O usuário " + id + " foi atualizado!");
    }

    @GetMapping
    @ApiOperation("Trazer todos os usuários")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(getUserService().getAllUsers());
    }

    @GetMapping("/{id}")
    @ApiOperation("Trazer usuário por ID")
    public ResponseEntity<Object> getUserById(@PathVariable(value = "id") int id)
    {
        Optional<UserModel> instituicaoModelOptional = getUserService().getUserById(id);

        return ResponseEntity.ok(instituicaoModelOptional);
    }

    @GetMapping("/cnpj/{cnpj}")
    @ApiOperation("Trazer usuário por CNPJ")
    public ResponseEntity<UserModel> getByCnpj(@PathVariable(value = "cnpj") String cnpj)
    {
        return ResponseEntity.ok(getUserService().getUserByCnpj(cnpj));
    }

    @GetMapping("/donors")
    @ApiOperation("Trazer usuário por tipo (Doador)")
    public ResponseEntity<List<UserModel>> getByTypeDonors()
    {
        return ResponseEntity.ok(getUserService().findAllByType(UserTypeEnum.DONOR));
    }

    @GetMapping("/recievers")
    @ApiOperation("Trazer usuário por tipo (Recebedor)")
    public ResponseEntity<List<UserModel>> getByTypeRecievers()
    {
        return ResponseEntity.ok(getUserService().findAllByType(UserTypeEnum.RECEIVER));
    }

    public UserService getUserService() {
        return userService;
    }
}
