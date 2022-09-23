package br.com.connectFood.controllers;

import java.util.List;
import java.util.Optional;

import br.com.connectFood.repository.InstituicaoRepository;
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

import br.com.connectFood.models.InstituicaoModel;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    InstituicaoRepository instituicaoRepository;

    @PostMapping
    public ResponseEntity<Object> cadastrarInstituicao(@RequestBody InstituicaoModel instituicao) {
        instituicaoRepository.save(instituicao);
        return ResponseEntity.ok(instituicao);
    }

    @GetMapping
    public ResponseEntity<List<InstituicaoModel>> getAllInstituicao() {
        return ResponseEntity.ok(instituicaoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getInstituicaoById(@PathVariable(value = "id") int id) {
        Optional<InstituicaoModel> instituicaoModelOptional = instituicaoRepository.findById(id);
        return ResponseEntity.ok(instituicaoModelOptional);
    }

    @GetMapping("/cnpj/{cnpj}")
    public InstituicaoModel getByCnpj(@PathVariable(value = "cnpj") String cnpj)
    {
        return instituicaoRepository.findByCnpj(cnpj);
    }

    @GetMapping("/estado/{estado}")
    public List<InstituicaoModel> getByEstado(@PathVariable(value = "estado") String estado)
    {
        return instituicaoRepository.findByEstado(estado);
    }

    @GetMapping("/cidade/{cidade}")
    public List<InstituicaoModel> getByCidade(@PathVariable(value = "cidade") String cidade)
    {
        return instituicaoRepository.findByCidade(cidade);
    }

    @GetMapping("/bairro/{bairro}")
    public List<InstituicaoModel> getByBairro(@PathVariable(value = "bairro") String bairro)
    {
        return instituicaoRepository.findByBairro(bairro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInstituicao(@PathVariable(value = "id") int id) {
        instituicaoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarInstituicao(@PathVariable(value = "id") int id,
                                                       @RequestBody InstituicaoModel instituicao) {
        instituicao.setId(id);
        return ResponseEntity.ok(instituicaoRepository.save(instituicao));

    }
}
