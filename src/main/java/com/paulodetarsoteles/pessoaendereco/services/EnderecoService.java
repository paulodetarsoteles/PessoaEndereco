package com.paulodetarsoteles.pessoaendereco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulodetarsoteles.pessoaendereco.models.Endereco;
import com.paulodetarsoteles.pessoaendereco.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository; 
	
	public List<Endereco> findAll(){
		return repository.findAll(); 
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> result = repository.findById(id);
		return result.get(); 
	}
}
