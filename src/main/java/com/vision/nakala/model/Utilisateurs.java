package com.vision.nakala.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "utilisateurs")
@Getter
@Setter
public class Utilisateurs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "UtilisateursIdGenerator")
	@GenericGenerator(name = "UtilisateursIdGenerator", strategy = "native")
	@Column(name = "ID", nullable = false, insertable = true, updatable = false)
	private long id;

	@Column(name = "NAME", nullable = false)
	@NotBlank(message = "Name is mandatory")
	private String nom;

	@Column(name = "BIRTHDAY", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	@NotNull(message = "Birthday is mandatory")
	@Past(message = "Birthday must be a date in the past")
	private LocalDate dateNaissance;

	@Column(name = "RESIDENCE", nullable = false)
	@NotBlank(message = "Country of residence is mandatory")
	private String paysResidence;

	@Column(name = "CALL", nullable = true)
	private String telephone;

	@Column(name = "GENDER", nullable = true)
	private String genre;
}
