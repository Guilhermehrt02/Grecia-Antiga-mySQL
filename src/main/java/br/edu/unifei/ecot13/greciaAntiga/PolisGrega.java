package br.edu.unifei.ecot13.greciaAntiga;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = false)
public class PolisGrega implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8250782567647628741L;
	@Id
	private String governante;
	private String periodo;
	private String enfaseEducacao;
	
	
}
