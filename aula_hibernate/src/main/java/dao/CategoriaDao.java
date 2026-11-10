package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Categoria;

public class CategoriaDao {
	
	private EntityManager em;
	
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria Categoria) {
		em.getTransaction().begin();
		this.em.persist(Categoria);
		em.getTransaction().commit();
	}
	
	public void atualizar(Categoria Categoria) {
		em.getTransaction().begin();
		this.em.merge(Categoria);
		em.getTransaction().commit();
	}
	
	public void remover(Integer id) {
		em.getTransaction().begin();
		Categoria Categoria = em.find(Categoria.class, id);
		em.remove(Categoria);
		em.getTransaction().commit();
	}

	public Categoria buscarPorId(long id) {
		return em.find(Categoria.class, id);
	}
	
	// buscar todos os Categorias
	public List<Categoria> buscarTodos() {
		String jpql = "SELECT c FROM Categoria c";
		return em.createQuery(jpql, Categoria.class).getResultList();
	}
	
}
