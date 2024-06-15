package br.edu.unifei.ecot13.greciaAntiga;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Esparta extends PolisGrega{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5485552595762327588L;
	private boolean guerrasVencidas;
	@OneToMany
	private List<Espartano> espartanos = new ArrayList<Espartano>();
	
	
}
