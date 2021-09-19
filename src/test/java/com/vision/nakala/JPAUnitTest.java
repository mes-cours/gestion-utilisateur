package com.vision.nakala;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.vision.nakala.model.Utilisateurs;
import com.vision.nakala.repository.UtilisateursRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAUnitTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UtilisateursRepository repository;

	@Test
	public void should_store_a_user() {
		Utilisateurs utilisateur = new Utilisateurs(0, "Khalifa", LocalDate.now(), "French", "775273025", "Masculin");
		repository.save(utilisateur);

		assertThat(utilisateur).hasFieldOrPropertyWithValue("nom", "Khalifa");
		assertThat(utilisateur).hasFieldOrPropertyWithValue("paysResidence", "French");
		assertThat(utilisateur).hasFieldOrPropertyWithValue("genre", "Masculin");
	}

	@Test
	public void should_find_user_by_id() {
		Utilisateurs user1 = new Utilisateurs(0, "Khalifa", LocalDate.now(), "French", "775273025", "Masculin");
		entityManager.persist(user1);

		Utilisateurs user2 = new Utilisateurs(0, "Anta", LocalDate.now(), "French", "779477258", "Feminin");
		entityManager.persist(user2);

		Utilisateurs foundUser = repository.findById(user2.getId()).get();

		assertThat(foundUser).isEqualTo(user2);
	}

}