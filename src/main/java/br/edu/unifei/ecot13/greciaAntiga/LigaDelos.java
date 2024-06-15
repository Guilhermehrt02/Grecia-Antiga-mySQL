package br.edu.unifei.ecot13.greciaAntiga;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class LigaDelos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6723224997100257364L;
	@Id
	private String sedeDelos;
	private boolean novoTerritorio;
	@OneToOne
	private Esparta esparta;
}
