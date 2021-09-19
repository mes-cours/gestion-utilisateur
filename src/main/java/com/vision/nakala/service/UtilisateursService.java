package com.vision.nakala.service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vision.nakala.aspect.LogEntryExit;
import com.vision.nakala.error.ResourceNotFoundException;
import com.vision.nakala.model.Utilisateurs;
import com.vision.nakala.repository.UtilisateursRepository;

@Service
public class UtilisateursService {

	@Autowired
	UtilisateursRepository utilisateursRepository;

	@LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
	public Utilisateurs creerUser(Utilisateurs user) {
		return utilisateursRepository.save(user);
	}

	@LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
	public Optional<Utilisateurs> getUtilisateurById(Long id) throws ResourceNotFoundException {
		return utilisateursRepository.findById(id);
	}
}
