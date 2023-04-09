package com.paulodetarsoteles.pessoaendereco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulodetarsoteles.pessoaendereco.models.Pessoa;
import com.paulodetarsoteles.pessoaendereco.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;  
	
	public List<Pessoa> findAll(){
		return repository.findAll(); 
	}
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> result = repository.findById(id);
		return result.get(); 
	}
	
	public Pessoa insert(Pessoa pessoa) {
		return repository.save(pessoa); 
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
