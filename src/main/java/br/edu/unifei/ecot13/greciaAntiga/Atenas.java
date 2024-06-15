package br.edu.unifei.ecot13.greciaAntiga;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Atenas extends PolisGrega {
	/**
	 * 
	 */
	private static final long serialVersionUID = -806218911972989207L;
	private int qtdVotos;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ateniense> atenienses = new ArrayList<Ateniense>();
	
}
