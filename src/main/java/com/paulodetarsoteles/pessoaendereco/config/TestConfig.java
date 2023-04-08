package com.paulodetarsoteles.pessoaendereco.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.paulodetarsoteles.pessoaendereco.models.Pessoa;
import com.paulodetarsoteles.pessoaendereco.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa(null, "Paulo");
		Pessoa p2 = new Pessoa(null, "Rita");
		Pessoa p3 = new Pessoa(null, "Julia");
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3)); 
	} 
}
