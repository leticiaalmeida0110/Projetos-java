package testes;

import java.time.LocalDate;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Contato;

public class Teste1 {
	public static void main(String[] args) {
		//carrega a unidade de persistencia (persistance.xml)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meus_contatos");
		//estabelece conexao
		jakarta.persistence.EntityManager em = emf.createEntityManager();
			
		//System.out.println("Conectou!");
			
		Contato contato = new Contato(null, "Maria","35712542", "maria@gmail.com", LocalDate.of(1995, 07, 25));
			
		//insert
		em.getTransaction().begin();
		em.persist(contato);
		em.getTransaction().commit();
			
			
		em.close();
		emf.close();
		}
		
	}