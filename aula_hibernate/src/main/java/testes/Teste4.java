package testes;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Contato;
import utils.JPAUtils;

public class Teste4 {
	public static void main(String[] args) {
		//carrega a unidade de persistencia (persistance.xml)
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("meus_contatos");
		//estabelece conexao
		//jakarta.persistence.EntityManager em = emf.createEntityManager();
		//System.out.println("Conectou!");
			
		EntityManager em = JPAUtils.getEntityManager();
		
		//estado detached
		Contato contato = new Contato(2, "José Antônio Pereira","1111-1111", "josé2@gmail.com", LocalDate.of(1995, 07, 25));
			
		//update
		em.getTransaction().begin();
		//contato = em.merge(contato);//estado managed
		contato = em.find(Contato.class, contato.getId()); //estado managed
		em.remove(contato);//estado removed
		em.getTransaction().commit();
			
			
		em.close();
		//emf.close();
		}
		
	}