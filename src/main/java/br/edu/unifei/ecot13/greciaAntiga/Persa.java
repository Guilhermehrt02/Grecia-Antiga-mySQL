package br.edu.unifei.ecot13.greciaAntiga;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Persa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6790831574737621319L;
	@Id
	private String governante;
	private String periodo;
	private boolean imperador;
	
}
