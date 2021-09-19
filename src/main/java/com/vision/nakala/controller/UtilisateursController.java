package com.vision.nakala.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.nakala.error.ResourceNotFoundException;
import com.vision.nakala.model.Utilisateurs;
import com.vision.nakala.service.UtilisateursService;

@RestController
@RequestMapping("/api")
public class UtilisateursController {

	@Autowired
	UtilisateursService utilisateurService;

	@PostMapping("/users")
	public ResponseEntity<Utilisateurs> createUsers(@Valid @RequestBody Utilisateurs user) {
		try {
			Period diff = Period.between(LocalDate.parse(user.getDateNaissance().toString()), LocalDate.now());
			if (user.getPaysResidence().equalsIgnoreCase("French") && diff.getYears() >= 18) {
				Utilisateurs _user = utilisateurService.creerUser(new Utilisateurs(0, user.getNom(), user.getDateNaissance(),
						user.getPaysResidence(), user.getTelephone(), user.getGenre()));
				return new ResponseEntity<>(_user, HttpStatus.CREATED);
			}
			return new ResponseEntity<>(null, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Utilisateurs> getUtilisateurById(@PathVariable("id") long id) throws ResourceNotFoundException {
		Optional<Utilisateurs> userData = utilisateurService.getUtilisateurById(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
