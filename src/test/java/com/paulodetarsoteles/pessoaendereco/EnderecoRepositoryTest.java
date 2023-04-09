package com.paulodetarsoteles.pessoaendereco;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.paulodetarsoteles.pessoaendereco.models.Endereco;
import com.paulodetarsoteles.pessoaendereco.repositories.EnderecoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EnderecoRepositoryTest {

	@Autowired
	private EnderecoRepository repository; 
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none(); 
	
	@Test
	public void createShouldPersistData() {
		Endereco eTest = new Endereco(null, "Rua Jota", "60831080", 610, "Fortaleza", true, null); 
		this.repository.save(eTest); 
		Assertions.assertThat(eTest.getEnderecoId()).isNotNull(); 
		Assertions.assertThat(eTest.getLogradouro()).isNotNull(); 
		Assertions.assertThat(eTest.getLogradouro()).isEqualTo("Rua Jota"); 
		Assertions.assertThat(eTest.getNumero()).isNotNull();
		Assertions.assertThat(eTest.getNumero()).isEqualTo(610);
		Assertions.assertThat(eTest.getPrincipal()).isTrue(); 
	}
}
