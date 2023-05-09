package br.com.connectFood.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.connectFood.model.RestauranteModel;
import br.com.connectFood.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurante")

public class RestauranteController {

	@Autowired
	RestauranteRepository restauranteRepository;

	@PostMapping
	public ResponseEntity<Object> cadastrarRestaurante(@RequestBody RestauranteModel restaurante) {
		restauranteRepository.save(restaurante);
		return ResponseEntity.ok(restaurante);
	}

	@GetMapping
	public ResponseEntity<List<RestauranteModel>> getAllRestaurantes() {
		return ResponseEntity.ok(restauranteRepository.findAll());

	}

	@GetMapping("/cnpj/{cnpj}")
	public RestauranteModel getByCnpj(@PathVariable (value = "cnpj") String cnpj)
	{
		return restauranteRepository.findByCnpj(cnpj);
	}


	@GetMapping("/{id}")
	public ResponseEntity<Object> getRestauranteById(@PathVariable(value = "id") int id) {
		Optional<RestauranteModel> restauranteModelOptional = restauranteRepository.findById(id);
		return ResponseEntity.ok(restauranteModelOptional);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRestaurante(@PathVariable(value = "id") int id) {
		restauranteRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarRestaurante(@PathVariable(value = "id") int id,
			@RequestBody RestauranteModel restaurante) {
		restaurante.setId(id);
		return ResponseEntity.ok(restauranteRepository.save(restaurante));
	}

}
