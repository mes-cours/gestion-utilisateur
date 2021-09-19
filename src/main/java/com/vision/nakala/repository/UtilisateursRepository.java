package com.vision.nakala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vision.nakala.model.Utilisateurs;

@Repository
public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long>{

}
