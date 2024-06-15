package br.edu.unifei.ecot13.greciaAntiga;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Medicas extends Guerra{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9083973566214265211L;
	private String impactoResultante;
	@OneToOne
	private Persa persas;
	@OneToOne(cascade = CascadeType.ALL)
	private LigaDelos delos;
	
	
}
