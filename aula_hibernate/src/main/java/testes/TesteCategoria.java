package testes;

import dao.CategoriaDao;
import jakarta.persistence.EntityManager;
import model.Categoria;
import utils.JPAUtils;

public class TesteCategoria {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtils.getEntityManager();
		CategoriaDao dao = new CategoriaDao(em);
		
		Categoria contato = new Categoria(null, "Amigo");
		dao.cadastrar(contato);
		
		em.close();
	}

}
