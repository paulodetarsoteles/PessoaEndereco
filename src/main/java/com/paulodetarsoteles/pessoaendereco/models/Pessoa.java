package com.paulodetarsoteles.pessoaendereco.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pessoaId;
	private String nome;
	private Date dataNascimento;
	//private Long enderecoId; 
	
	public Pessoa() {
	}
	
	public Pessoa(Long pessoaId, String nome) {
		super();
		this.pessoaId = pessoaId;
		this.nome = nome;
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
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
