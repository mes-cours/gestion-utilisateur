package com.vision.nakala.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vision.nakala.model.Utilisateurs;

@Service
public interface UtilisateurService {
	
	Utilisateurs creerUser(Utilisateurs user);

	Optional<Utilisateurs> getUtilisateurById(Long id);
}
