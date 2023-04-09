package com.paulodetarsoteles.pessoaendereco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulodetarsoteles.pessoaendereco.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
