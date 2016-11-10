package it.alfasoft.martina;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean(name="p",eager=true)
@Embeddable
public class Prodotto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_ristorante;
	
	private String nome;
	private String prezzo;
	
	public Prodotto(){
		
	}

	public Prodotto(String nome, String prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
