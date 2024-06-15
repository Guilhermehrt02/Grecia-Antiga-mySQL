package br.edu.unifei.ecot13.greciaAntiga;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1194362111682745734L;
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	private String nome;

}
