package com.paulodetarsoteles.pessoaendereco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.paulodetarsoteles.pessoaendereco.models.Pessoa;
import com.paulodetarsoteles.pessoaendereco.repositories.PessoaRepository;
import com.paulodetarsoteles.pessoaendereco.services.exceptions.DataBaseExceptions;
import com.paulodetarsoteles.pessoaendereco.services.exceptions.ServicesExceptions;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;  
	
	public List<Pessoa> findAll(){
		return repository.findAll(); 
	}
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> result = repository.findById(id);
		return result.orElseThrow(() -> new ServicesExceptions(id)); 
	}
	
	public Pessoa insert(Pessoa pessoa) {
		return repository.save(pessoa); 
	}
	
	public Pessoa update(Long id, Pessoa pessoa) {
		try {
			Pessoa result = repository.getReferenceById(id); 
			updateData(result, pessoa); 
			return repository.save(result);
		} catch (EntityNotFoundException e) {
			throw new ServicesExceptions(id);
		}
	}
	
	private void updateData(Pessoa pessoa, Pessoa result) {
		pessoa.setNome(result.getNome());
		pessoa.setDataNascimento(result.getDataNascimento());
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ServicesExceptions(id); 
		} catch(EntityNotFoundException e) {
			throw new ServicesExceptions(id); 
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseExceptions(e.getMessage()); 
		} 
	}
}
