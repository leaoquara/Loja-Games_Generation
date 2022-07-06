package br.com.games.Loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.games.Loja.model.Categoria;
import br.com.games.Loja.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable String id) {
		return repository.findById(id)
							.map(m -> ResponseEntity.ok(m))
							.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED)
									.body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}
	
}
