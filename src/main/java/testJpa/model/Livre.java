package testJpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {
	@Id
	private Integer id;
	@Column(name = "Titre", length = 255, nullable = false)
	private String titre;
	@Column(name = "Auteur", length = 50, nullable = false)
	private String auteur;
	@ManyToMany
	@JoinTable(name = "compo", 
	joinColumns = @JoinColumn(name="id_liv", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="id_emp", referencedColumnName = "id"))
	
	private Set<Emprunt> emprunts;

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
}
