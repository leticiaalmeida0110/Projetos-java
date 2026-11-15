package testes;

//import java.time.LocalDate;

import dao.AlunoDao;
import jakarta.persistence.EntityManager;
//import model.Categoria;
import model.Aluno;
import utils.JPAUtils;
import java.util.List;


public class TesteAluno {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtils.getEntityManager();
		
		//Aluno cat = new Aluno(null, "Amigo");
		Aluno cont = new Aluno(null, "Luana", "35991345672", "luana@gmail.com", "Ciência da Computação");
		AlunoDao dao = new AlunoDao(em);
		dao.cadastrar(cont);
		

        // Buscar pelo ID
        Aluno a = dao.buscarPorId(1);
        System.out.println("BUSCA POR ID:");
        System.out.println(a);

        // Buscar todos
        List<Aluno> alunos = dao.buscarTodos();

        for (Aluno x : alunos) {
            System.out.println(x);
        }

        // Buscar pelo nome
        List<Aluno> resultado = dao.buscarPorNome("Julio");

        for (Aluno x : resultado) {
            System.out.println(x);
        }

        //alterar
         Aluno alterar = dao.buscarPorId(1);

        if (alterar != null) {
            alterar.setNome("Maria");
            alterar.setEmail("maria@gmail.com");

            dao.alterar(alterar);

            System.out.println("Aluno alterado!");
        }

        // Excluir pelo ID
        dao.excluir(1);
        System.out.println("Aluno excluído!");
        em.close();


    }
        
	}
