package br.edu.unifei.ecot13.greciaAntiga;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Peloponeso extends Guerra{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1628058343583168263L;
	private String impactoResultante;
	@OneToOne(cascade = CascadeType.ALL)
	private LigaDelos delos;
	@OneToOne
	private LigaPeloponeso peloponeso;
	
}
