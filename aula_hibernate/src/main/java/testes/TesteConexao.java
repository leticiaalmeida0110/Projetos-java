package testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteConexao {

    public static void main(String[] args) {

        // Carrega a unidade de persistência
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("meus_contatos");

        // Estabelece a conexão
        EntityManager em = emf.createEntityManager();

        System.out.println("Conectou!");

        em.close();
        emf.close();
    }
}