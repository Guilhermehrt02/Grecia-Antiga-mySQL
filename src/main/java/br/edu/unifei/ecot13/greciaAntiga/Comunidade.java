package br.edu.unifei.ecot13.greciaAntiga;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Comunidade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4717656246169639315L;
	@Id
	private String localizacao;
	private String economia;
	@OneToOne
	private PolisGrega polis;
	@OneToOne
	private Persa persa;
}
