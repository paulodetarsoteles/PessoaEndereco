package com.paulodetarsoteles.pessoaendereco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulodetarsoteles.pessoaendereco.models.Endereco;
import com.paulodetarsoteles.pessoaendereco.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service; 

	@GetMapping
	public ResponseEntity<List<Endereco>> findAll(){
		List<Endereco> result = service.findAll(); 
		//return ResponseEntity.ok(result);
		return ResponseEntity.ok().body(result); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id){
		Endereco result = service.findById(id); 
		return ResponseEntity.ok().body(result); 
	}
}
