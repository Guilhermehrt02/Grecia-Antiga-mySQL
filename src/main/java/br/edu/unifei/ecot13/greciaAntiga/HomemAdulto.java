package br.edu.unifei.ecot13.greciaAntiga;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class HomemAdulto extends Ateniense {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8735473810654079787L;
	private int idade;
}
