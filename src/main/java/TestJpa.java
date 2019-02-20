import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Livre;

public class TestJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Livre livre = em.find(Livre.class, 1);
		if (livre != null){
		System.out.println(livre.getTitre());
		System.out.println(livre.getAuteur());
		}
		Query query = em.createQuery("SELECT l FROM Livre l WHERE l.titre = 'Vingt mille lieues sous les mers'");
		livre = (Livre) query.getSingleResult();
		if (livre != null){
			System.out.println(livre.getTitre());
			System.out.println(livre.getAuteur());
			}
	}

}
