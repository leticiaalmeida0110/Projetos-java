package testes;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
import model.Contato;
import utils.JPAUtils;

public class Teste2 {
	public static void main(String[] args) {
		//carrega a unidade de persistencia (persistance.xml)
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("meus_contatos");
		//estabelece conexao
		//jakarta.persistence.EntityManager em = emf.createEntityManager();
		//System.out.println("Conectou!");
			
		EntityManager em = JPAUtils.getEntityManager();
		
		//estado detached
		Contato contato = new Contato(2, "José Antônio Pereira","35712542", "josé2@gmail.com", LocalDate.of(1995, 07, 25), null);
			
		//update
		em.getTransaction().begin();
		contato = em.merge(contato);//estado managed
		contato.setCelular("1111-1111");
		em.getTransaction().commit();
			
			
		em.close();
		//emf.close();
		}
		
	}