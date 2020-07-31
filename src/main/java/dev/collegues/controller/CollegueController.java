package dev.collegues.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.exception.CodeErreur;
import dev.collegue.exception.CollegueException;
import dev.collegue.exception.CollegueNonTrouveException;
import dev.collegue.exception.MessageErreur;
import dev.collegues.dto.CollegueDto;
import dev.collegues.dto.CollegueMapper;
import dev.collegues.dto.CreerCollegueDto;
import dev.collegues.dto.UpdateCollegueDto;
import dev.collegues.entite.Collegue;
import dev.collegues.service.CollegueService;

@CrossOrigin(origins = "*")
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
		List<Collegue> collegues = service.getCollegues(matricule);
		if(!collegues.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(collegues);
		}
		else {
			throw new CollegueNonTrouveException(new MessageErreur(CodeErreur.VALIDATION, "Ce collègue n'existe pas"));
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> postCollegue(@RequestBody @Valid CreerCollegueDto collegue, BindingResult result) {
		
		if (result.hasErrors()) {
			throw new CollegueException(new MessageErreur(CodeErreur.VALIDATION, "Données invalides pour la création d'un client"));
		}
		
		Collegue collegueCree = service.creer(collegue.getNom(), collegue.getPrenoms(), collegue.getEmail(), collegue.getDateDeNaissance(), collegue.getPhotoUrl());
		CollegueDto collegueDto = CollegueMapper.INSTANCE.collegueToCollegueDto(collegueCree);
		return ResponseEntity.ok(collegueDto);
	}
	
	@PatchMapping("{matricule}")
	public ResponseEntity<?> patchCollegue(@RequestBody UpdateCollegueDto collegueDto, @PathVariable String matricule, BindingResult result){
		List<Collegue> collegues = service.getCollegues(matricule);
		if (result.hasErrors()) {
			throw new CollegueException(new MessageErreur(CodeErreur.VALIDATION, "Données invalides pour la création d'un client"));
		}
		if(collegues.isEmpty()) {
			throw new CollegueNonTrouveException(new MessageErreur(CodeErreur.VALIDATION, "Ce collègue n'existe pas"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(service.update(collegueDto, matricule));
	}
	

}
