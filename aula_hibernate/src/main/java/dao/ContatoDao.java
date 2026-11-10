package dao;

//import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import model.Contato;
import utils.JPAUtils;

public class ContatoDao {

	private EntityManager em;//conexao
	
	public ContatoDao(EntityManager em) {
		this.em = em;
	}

	
	public void cadastrar(Contato cont) {
		em.getTransaction().begin();
		em.persist(cont);
		em.getTransaction().commit();
	}
	
	public void alterar(Contato cont) {
		em.getTransaction().begin();
		em.merge(cont);
		em.getTransaction().commit();
	}
	
	public void excluir(int id) {
		em.getTransaction().begin();
		Contato cont = em.find(Contato.class, id);
		em.remove(cont);
		em.getTransaction().commit();
	}
	
	public Contato buscarPorId(int id){
		return em.find(Contato.class, id);
	}
	
	public static void main(String[] args) {
		ContatoDao dao  = new ContatoDao(JPAUtils.getEntityManager());
		//Contato contato = new Contato(null, "julio", "35712544", "ju@gmail.com", LocalDate.of(1995, 7, 26));
		//dao.cadastrar(contato);
		
		//Contato contato = new Contato(15, "carlo", "35712544", "carlo@gmail.com", LocalDate.of(1995, 7, 26));
		//dao.alterar(contato); 
		
		//dao.excluir(10);
		Contato c = dao.buscarPorId(15);
		System.out.println(c.toString());
	}
}
