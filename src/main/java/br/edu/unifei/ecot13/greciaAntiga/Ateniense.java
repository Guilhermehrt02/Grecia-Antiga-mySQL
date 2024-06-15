package br.edu.unifei.ecot13.greciaAntiga;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Ateniense extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = -200932650425382756L;
	private boolean filosofo;
	
}
