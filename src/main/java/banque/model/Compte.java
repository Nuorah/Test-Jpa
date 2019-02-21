package banque.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Compte {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="numero", length = 50, nullable = false)
	private String numero;
	@Column(name="solde", nullable = false)
	private Double solde;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;	
	
	@ManyToMany
	@JoinTable(name="client_compte",
	joinColumns = @JoinColumn(name="id_compte",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="id_client", referencedColumnName = "id"))
	
	private Set<Client> clients;
	
	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	public Set<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	
}
