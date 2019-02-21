package banque.console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.model.Adresse;
import banque.model.AssuranceVie;
import banque.model.Banque;
import banque.model.Client;
import banque.model.Compte;
import banque.model.LivretA;
import banque.model.Operation;
import banque.model.Virement;

public class testBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();

		Client client = new Client();

		Adresse adresse = new Adresse();
		adresse.setCodePostal(45800);
		adresse.setNumero(18);
		adresse.setRue("George Sand");
		adresse.setVille("Saint-Jean-de-Braye");

		client.setAdresse(adresse);
		client.setDateNaissance(LocalDate.of(1989, Month.APRIL, 17));
		client.setNom("Moatassime");
		client.setPrenom("Haroun");

		Banque banque = new Banque();
		banque.setNom("ING direct");

		client.setBanque(banque);

		LivretA livretA = new LivretA();
		livretA.setNumero("1968");
		livretA.setSolde(90.0);
		livretA.setTaux(2.0);
		
		AssuranceVie assuranceVie = new AssuranceVie();
		assuranceVie.setNumero("1969");
		assuranceVie.setSolde(1000.0);
		assuranceVie.setTaux(2.5);
		assuranceVie.setDateFin(LocalDate.of(2050, Month.MARCH, 3));
		
		Set<Client> clients = new HashSet<Client>();
		clients.add(client);
		livretA.setClients(clients);
		assuranceVie.setClients(clients);

		Virement operation1 = new Virement();
		operation1.setCompte(livretA);
		operation1.setDate(LocalDateTime.now());
		operation1.setMontant(11.0);
		operation1.setMotif("Achat Pizza");	
		operation1.setBeneficiaire("Pizza Hut");
		
		Virement operation2 = new Virement();
		operation2.setCompte(livretA);
		operation2.setDate(LocalDateTime.now());
		operation2.setMontant(11.5);
		operation2.setMotif("Achat encore une Pizza");
		operation2.setBeneficiaire("Pizzeria Rialto");

		Set<Compte> comptes = new HashSet<Compte>();
		comptes.add(livretA);
		comptes.add(assuranceVie);

		client.setComptes(comptes);

		EntityTransaction transaction1 = em.getTransaction();
		transaction1.begin();
		em.persist(client);
		em.persist(operation1);
		em.persist(operation2);
		em.persist(livretA);
		em.persist(assuranceVie);
		em.persist(banque);

		transaction1.commit();
		/*EntityTransaction transaction2 = em.getTransaction();
		transaction2.begin();
		em.persist(operation);
		transaction2.commit();*/
	}

}
