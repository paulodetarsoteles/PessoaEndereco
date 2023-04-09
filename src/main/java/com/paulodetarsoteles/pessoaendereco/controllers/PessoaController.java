package com.paulodetarsoteles.pessoaendereco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
