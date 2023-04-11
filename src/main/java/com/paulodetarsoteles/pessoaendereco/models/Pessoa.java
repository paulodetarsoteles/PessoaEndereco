package com.paulodetarsoteles.pessoaendereco.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long pessoaId;
	private String nome;
	private Instant dataNascimento;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> enderecos = new ArrayList<>(); 
	
	public Pessoa() {
	}
	
	public Pessoa(Long pessoaId, String nome, Instant datanascimento) {
		super();
		this.pessoaId = pessoaId;
		this.nome = nome;
		this.dataNascimento = datanascimento; 
	}
	
	public Long getPessoaId() {
		return pessoaId;
	}
	
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Instant getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(dataNascimento, other.dataNascimento);
	}
}
