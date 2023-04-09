package com.paulodetarsoteles.pessoaendereco;

import java.time.Instant;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.paulodetarsoteles.pessoaendereco.models.Pessoa;
import com.paulodetarsoteles.pessoaendereco.repositories.PessoaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryTest {

	@Autowired
	private PessoaRepository repository; 
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none(); 
	
	@Test
	public void createShouldPersistData() {
		Pessoa pTest = new Pessoa(null, "Pedro", Instant.parse("1983-12-24T00:00:00Z"));
		this.repository.save(pTest); 
		Assertions.assertThat(pTest.getPessoaId()).isNotNull();
		Assertions.assertThat(pTest.getNome()).isNotNull(); 
		Assertions.assertThat(pTest.getNome()).isEqualTo("Pedro"); 
		Assertions.assertThat(pTest.getDataNascimento()).isNotNull(); 
	}
}
