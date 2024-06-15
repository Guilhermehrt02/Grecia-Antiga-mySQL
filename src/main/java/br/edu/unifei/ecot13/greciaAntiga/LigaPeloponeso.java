package br.edu.unifei.ecot13.greciaAntiga;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class LigaPeloponeso implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -4863417174025980701L;
	@Id
	private String sedePeloponeso;
//	@ElementCollection(targetClass=String.class)
//	private List<String> aliados = new ArrayList<String>();
	private String aliado;
	private boolean muralhaDerrubada;
	@OneToOne
	private Esparta esparta;
	
}
