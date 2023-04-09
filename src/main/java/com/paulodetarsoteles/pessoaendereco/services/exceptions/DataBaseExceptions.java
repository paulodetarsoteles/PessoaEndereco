package com.paulodetarsoteles.pessoaendereco.services.exceptions;

public class DataBaseExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataBaseExceptions(String msg) {
		super(msg); 
	}
}
