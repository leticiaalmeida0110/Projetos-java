package testes;

import java.time.LocalDate;

import dao.ContatoDao;
import jakarta.persistence.EntityManager;
import model.Categoria;
import model.Contato;
import utils.JPAUtils;

public class TesteContato {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtils.getEntityManager();
		
		Categoria cat = new Categoria(null, "Amigo");
		Contato cont = new Contato(null, "Luana", "35991124567", "luna@gmail.com", LocalDate.now(), cat);
		
		ContatoDao dao = new ContatoDao(em);
		dao.cadastrar(cont);
		
		em.close();
	}

}
