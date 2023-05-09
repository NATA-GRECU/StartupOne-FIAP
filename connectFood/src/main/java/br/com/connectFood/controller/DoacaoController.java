package br.com.connectFood.controller;

import java.util.List;
import java.util.Optional;

import br.com.connectFood.repository.DoacaoRepository;
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

import br.com.connectFood.model.DoacaoModel;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {

    @Autowired
    DoacaoRepository doacaoRepository;

    @PostMapping
    public ResponseEntity<Object> cadastrarDoacao(@RequestBody DoacaoModel doacao) {
        doacaoRepository.save(doacao);
        return ResponseEntity.ok(doacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDoacao(@PathVariable(value = "id") int id) {
        doacaoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarDoacao(@PathVariable(value = "id") int id, @RequestBody DoacaoModel doacao) {
        doacao.setId(id);
        return ResponseEntity.ok(doacaoRepository.save(doacao));
    }

    @GetMapping
    public ResponseEntity<List<DoacaoModel>> getAllDoacao() {
        return ResponseEntity.ok(doacaoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoacaoById(@PathVariable(value = "id") int id) {
        Optional<DoacaoModel> doacaoModelOptional = doacaoRepository.findById(id);
        return ResponseEntity.ok(doacaoModelOptional);
    }

    @GetMapping("/restaurante/{nome}")
    public ResponseEntity<Object> getDoacaoByRestaurante(@PathVariable(value = "nome") String nome) {
        return ResponseEntity.ok(doacaoRepository.findByRestaurante_NomeRestaurante(nome));
    }

    @GetMapping("/instituicao/{nome}")
    public ResponseEntity<Object> getDoacaoByInstituicao(@PathVariable(value = "nome") String nome) {
        return ResponseEntity.ok(doacaoRepository.findByInstituicao_NomeInstituicao(nome));
    }
}