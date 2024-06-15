package br.edu.unifei.ecot13.greciaAntiga;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Guerra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5540747969532083169L;
	@Id
	private String vencedor;
	private String motivo;
	
	
}
