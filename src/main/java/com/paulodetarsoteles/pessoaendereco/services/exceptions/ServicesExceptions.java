package com.paulodetarsoteles.pessoaendereco.services.exceptions;

public class ServicesExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ServicesExceptions(Object id) {
		super("Recurso não encontrado. " + id); 
	}
}
