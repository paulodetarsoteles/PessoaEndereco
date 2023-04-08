package com.paulodetarsoteles.pessoaendereco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulodetarsoteles.pessoaendereco.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
