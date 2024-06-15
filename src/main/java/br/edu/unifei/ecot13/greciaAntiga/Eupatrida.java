package br.edu.unifei.ecot13.greciaAntiga;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Eupatrida extends Ateniense {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8939848250037217057L;
	private String posse;
	
}
