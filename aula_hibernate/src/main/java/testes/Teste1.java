package testes;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Contato;
import utils.JPAUtils;

public class Teste1 {
	public static void main(String[] args) {
		//carrega a unidade de persistencia (persistance.xml)
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("meus_contatos");
		//estabelece conexao
		//jakarta.persistence.EntityManager em = emf.createEntityManager();
		//System.out.println("Conectou!");
			
		EntityManager em = JPAUtils.getEntityManager();
		
		//estado transiente
		Contato contato = new Contato(null, "José","35712542", "josé2@gmail.com", LocalDate.of(1995, 07, 25));
			
		//insert
		em.getTransaction().begin();
		em.persist(contato);//estado managed
		contato.setNome("José Antônio");
		em.getTransaction().commit();
			
			
		em.close();
		//emf.close();
		}
		
	}