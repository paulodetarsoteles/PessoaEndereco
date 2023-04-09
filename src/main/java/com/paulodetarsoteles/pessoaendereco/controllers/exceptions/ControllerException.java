package com.paulodetarsoteles.pessoaendereco.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.paulodetarsoteles.pessoaendereco.services.exceptions.DataBaseExceptions;
import com.paulodetarsoteles.pessoaendereco.services.exceptions.ServicesExceptions;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler(ServicesExceptions.class)
	public ResponseEntity<StandartError> resourceNotFound(ServicesExceptions e, HttpServletRequest request){
		
		String error = "Recurso não encontrado"; 
		HttpStatus status = HttpStatus.NOT_FOUND; 
		StandartError er = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); 
		return ResponseEntity.status(status).body(er); 
	}
	
	@ExceptionHandler(DataBaseExceptions.class)
	public ResponseEntity<StandartError> dataBaseError(DataBaseExceptions e, HttpServletRequest request){
		
		String error = "Erro no banco de dados"; 
		HttpStatus status = HttpStatus.BAD_REQUEST; 
		StandartError er = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); 
		return ResponseEntity.status(status).body(er); 
	}
}
