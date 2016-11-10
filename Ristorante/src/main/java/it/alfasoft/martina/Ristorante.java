package it.alfasoft.martina;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean(name="r",eager=true)
@Entity
public class Ristorante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_ristorante;
	
	private String nome;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<Prodotto> primi =new HashSet<Prodotto>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<Prodotto> secondi =new HashSet<Prodotto>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<Prodotto> dessert =new HashSet<Prodotto>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<Prodotto> bevande =new HashSet<Prodotto>();
	
	public Ristorante(){
		
	}

	public Ristorante(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Prodotto> getPrimi() {
		return primi;
	}

	public void setPrimi(Set<Prodotto> primi) {
		this.primi = primi;
	}

	public Set<Prodotto> getSecondi() {
		return secondi;
	}

	public void setSecondi(Set<Prodotto> secondi) {
		this.secondi = secondi;
	}

	public Set<Prodotto> getDessert() {
		return dessert;
	}

	public void setDessert(Set<Prodotto> dessert) {
		this.dessert = dessert;
	}

	public Set<Prodotto> getBevande() {
		return bevande;
	}

	public void setBevande(Set<Prodotto> bevande) {
		this.bevande = bevande;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void addProdotto(Prodotto p){
		
	}
}
