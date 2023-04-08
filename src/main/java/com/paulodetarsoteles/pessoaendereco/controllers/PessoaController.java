package com.paulodetarsoteles.pessoaendereco.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulodetarsoteles.pessoaendereco.models.Pessoa;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@GetMapping
	public ResponseEntity<Pessoa> findAll(){
		
		//return ResponseEntity.ok(p);
		//return ResponseEntity.ok().body();
		return ResponseEntity.ok(null); 
	}
}
