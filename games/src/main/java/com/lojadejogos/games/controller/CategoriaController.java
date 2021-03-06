package com.lojadejogos.games.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lojadejogos.games.model.Categoria;
import com.lojadejogos.games.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById (@PathVariable long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Categoria>> GetByGenero (@PathVariable String genero)
	{
		return ResponseEntity.ok(repository.findAllByGeneroContainingIgnoreCase(genero));
	}
	
	@GetMapping("/origem/{origem}")
	public ResponseEntity<List<Categoria>> GetByOrigem (@PathVariable String origem)
	{
		return ResponseEntity.ok(repository.findAllByGeneroContainingIgnoreCase(origem));
	}
}