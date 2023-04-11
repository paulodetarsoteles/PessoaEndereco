package com.paulodetarsoteles.pessoaendereco.controllers;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value = "/findPrincipal/{pessoaId}")
	public ResponseEntity<List<Endereco>> findPrincipal(@PathVariable Long pessoaId){
		List<Endereco> result = service.findPrincipal(pessoaId); 
		return ResponseEntity.ok().body(result); 
	}
	
	@PostMapping 
	public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco){
		Endereco obj = service.insert(endereco);
		URI result = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getEnderecoId())
				.toUri(); 
		return ResponseEntity.created(result).body(obj);  
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco){
		Endereco result = service.update(id, endereco); 
		return ResponseEntity.ok().body(result); 
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build(); 
	}
}
