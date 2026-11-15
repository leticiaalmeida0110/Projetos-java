package dao;
//import java.time.LocalDate;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Aluno;
//import utils.JPAUtils;

public class AlunoDao {

	private EntityManager em;//conexao
	
	public AlunoDao(EntityManager em) {
		this.em = em;
	}

	
	public void cadastrar(Aluno cont) {
		em.getTransaction().begin();
		em.persist(cont);
		em.getTransaction().commit();
	}
	
	public void alterar(Aluno cont) {
		em.getTransaction().begin();
		em.merge(cont);
		em.getTransaction().commit();
	}
	
	public void excluir(int id) {
		em.getTransaction().begin();
		Aluno cont = em.find(Aluno.class, id);
		em.remove(cont);
		em.getTransaction().commit();
	}
	
	public Aluno buscarPorId(int id){
		return em.find(Aluno.class, id);
	}
    
    public List<Aluno> buscarTodos() {
    String jpql = "SELECT a FROM Aluno a";

    return em.createQuery(jpql, Aluno.class)
             .getResultList();
    }

    public List<Aluno> buscarPorNome(String nome) {
    String jpql = "SELECT a FROM Aluno a WHERE a.nome LIKE :param_nome";

    return em.createQuery(jpql, Aluno.class)
             .setParameter("param_nome", "%" + nome + "%")
             .getResultList();
}

	
	//public static void main(String[] args) {
		//AlunoDao dao  = new AlunoDao(JPAUtils.getEntityManager());
        //Aluno aluno = new Aluno(null, "julio", "35712544", "ju@gmail.com", "Ciência da Computação");

		//Contato contato = new Contato(null, "julio", "35712544", "ju@gmail.com", LocalDate.of(1995, 7, 26));
		//dao.cadastrar(contato);
		
		//Contato contato = new Contato(15, "carlo", "35712544", "carlo@gmail.com", LocalDate.of(1995, 7, 26));
		//dao.alterar(contato); 
		
		//dao.excluir(10);
		//Aluno c = dao.buscarPorId(15);
		//System.out.println(c.toString());
	}