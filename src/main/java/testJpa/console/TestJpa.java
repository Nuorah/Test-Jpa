package testJpa.console;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import testJpa.model.Client;
import testJpa.model.Emprunt;
import testJpa.model.Livre;

public class TestJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();

		/*Livre livre = em.find(Livre.class, 2);
		if (livre != null){
			System.out.println(livre.getTitre());
			System.out.println(livre.getAuteur());
		}
		Query query = em.createQuery("SELECT l FROM Livre l WHERE l.titre = 'Vingt mille lieues sous les mers'");
		livre = (Livre) query.getSingleResult();
		if (livre != null){
			System.out.println(livre.getId());
			System.out.println(livre.getTitre());
			System.out.println(livre.getAuteur());
		}

		query = em.createQuery("SELECT e FROM Emprunt e WHERE e.id = 4");
		Emprunt emprunt = (Emprunt) query.getSingleResult();
		if (emprunt != null){
			for(Livre l:emprunt.getLivres()){
				System.out.println(l.getId());
				System.out.println(l.getTitre());
				System.out.println(l.getAuteur());
			}
		}*/
		Query query = em.createQuery("SELECT c FROM Client c WHERE c.id = 1");
		Client client = (Client) query.getSingleResult();
		System.out.println("Monsieur/madame " + client.getNom() + " a fait les emprunts suivants :");
		if (client != null){
			for(Emprunt e:client.getEmprunts()){
				System.out.println(e.getDate_debut());
				System.out.println(e.getDate_fin());
				System.out.println(e.getDelai());
				for(Livre l:e.getLivres()){
					System.out.println(l.getTitre());
					System.out.println(l.getAuteur());
				}
			}
		}
	}

}
