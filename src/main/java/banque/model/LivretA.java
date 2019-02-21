package banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
	
	@Column(name="taux", nullable = false)
	private Double taux;

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
