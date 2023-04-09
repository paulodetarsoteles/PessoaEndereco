package com.paulodetarsoteles.pessoaendereco.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.paulodetarsoteles.pessoaendereco.models.Pessoa;
import com.paulodetarsoteles.pessoaendereco.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService service; 

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> result = service.findAll(); 
		//return ResponseEntity.ok(result);
		return ResponseEntity.ok().body(result); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id){
		Pessoa result = service.findById(id); 
		return ResponseEntity.ok().body(result); 
	}
	
	@PostMapping 
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa pessoa){
		Pessoa obj = service.insert(pessoa);
		URI result = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getPessoaId()).toUri(); 
		return ResponseEntity.created(result).body(obj);  
	}
}
