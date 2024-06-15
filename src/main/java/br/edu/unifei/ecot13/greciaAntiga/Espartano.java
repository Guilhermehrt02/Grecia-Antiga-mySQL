package br.edu.unifei.ecot13.greciaAntiga;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Espartano extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4357512478977746105L;
	private String rei;
}
