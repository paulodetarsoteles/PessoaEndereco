package com.paulodetarsoteles.pessoaendereco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.paulodetarsoteles.pessoaendereco.models.Endereco;
import com.paulodetarsoteles.pessoaendereco.repositories.EnderecoRepository;
import com.paulodetarsoteles.pessoaendereco.services.exceptions.DataBaseExceptions;
import com.paulodetarsoteles.pessoaendereco.services.exceptions.ServicesExceptions;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository; 
	
	public List<Endereco> findAll(){
		return repository.findAll(); 
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> result = repository.findById(id);
		return result.orElseThrow(() -> new ServicesExceptions(id)); 
	}
	
	public List<Endereco> findPrincipal(Long id) {
		List<Endereco> result = repository.findAll().stream()
				.filter(e -> e.principal == true)
				.filter(e -> e.pessoa.pessoaId == id)
				.toList();
		return result; 
	}
	
	public Endereco insert(Endereco endereco) {
		return repository.save(endereco); 
	}
	
	public Endereco update(Long id, Endereco endereco) {
		try {
			Endereco result = repository.getReferenceById(id); 
			updateData(result, endereco); 
			return repository.save(result);
		} catch (EntityNotFoundException e) {
			throw new ServicesExceptions(id);
		}
	}
	
	private void updateData(Endereco endereco, Endereco result) {
		endereco.setLogradouro(result.getLogradouro());
		endereco.setCep(result.getCep());
		endereco.setNumero(result.getNumero());
		endereco.setCidade(result.getCidade());
		endereco.setPrincipal(result.getPrincipal()); 
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
