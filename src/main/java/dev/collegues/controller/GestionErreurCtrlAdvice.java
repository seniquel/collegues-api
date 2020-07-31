package dev.collegues.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.collegue.exception.CollegueException;
import dev.collegue.exception.CollegueNonTrouveException;
import dev.collegue.exception.MessageErreur;

@ControllerAdvice
public class GestionErreurCtrlAdvice {
	
	@ExceptionHandler(CollegueException.class)
	public ResponseEntity<MessageErreur> quandCollegueException(CollegueException ex) {
		return ResponseEntity.badRequest().body(ex.getMessageErreur());	
	}
	
	
	@ExceptionHandler(CollegueNonTrouveException.class)
	public ResponseEntity<MessageErreur> quandCollegueNonTrouveException(CollegueNonTrouveException ex) {
		return ((BodyBuilder) ResponseEntity.notFound()).body(ex.getMessageErreur());	
	}
}
