package banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {
	
	@Column(name="beneficiaire", length = 50, nullable = false)
	private String beneficiaire;

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}
