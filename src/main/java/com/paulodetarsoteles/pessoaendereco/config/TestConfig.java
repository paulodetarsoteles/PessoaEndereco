package com.paulodetarsoteles.pessoaendereco.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.paulodetarsoteles.pessoaendereco.models.Endereco;
import com.paulodetarsoteles.pessoaendereco.models.Pessoa;
import com.paulodetarsoteles.pessoaendereco.repositories.EnderecoRepository;
import com.paulodetarsoteles.pessoaendereco.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository; 

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa(null, "Paulo", Instant.parse("1983-12-24T00:00:00Z"));
		Pessoa p2 = new Pessoa(null, "Rita", Instant.parse("1987-01-08T00:00:00Z"));
		Pessoa p3 = new Pessoa(null, "Julia", Instant.parse("2009-01-17T00:00:00Z"));
		
		Endereco e1 = new Endereco(null, "Rua Jota", "60831080", 610, "Fortaleza", p1);
		Endereco e2 = new Endereco(null, "Av. Bezerra", "60325000", 810, "Fortaleza", p1);
		Endereco e3 = new Endereco(null, "Rua Costa Barros", "60119000", 915, "Fortaleza", p1);
		Endereco e4 = new Endereco(null, "Rua Amadeu Furtado", "60355003", 905, "Fortaleza", p2);
		Endereco e5 = new Endereco(null, "Rua Ajurana", "60325900", 26, "Fortaleza", p2);
		Endereco e6 = new Endereco(null, "Rua Padre Guerra", "60300001", 706, "Aquiraz", p3);
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3)); 
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6)); 
	} 
}
