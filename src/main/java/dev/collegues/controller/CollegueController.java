package dev.collegues.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entite.Collegue;
import dev.collegues.service.CollegueService;

@RestController
@RequestMapping("collegues")
public class CollegueController {
	
	private CollegueService service;

	public CollegueController(CollegueService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<String>> getMatricules(
			@RequestParam String nom) {	
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getMatricules(nom));
	}
	
	@GetMapping("{matricule}")
	public ResponseEntity<List<Collegue>> getCollegueByMatricule(@PathVariable String matricule){
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getCollegues(matricule));
	}

}
