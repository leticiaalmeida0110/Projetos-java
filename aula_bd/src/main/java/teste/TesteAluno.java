package teste;

import java.sql.SQLException;
import dao.AlunoDao;
import model.Aluno;

public class TesteAluno {

    public static void main(String[] args) {

        AlunoDao dao = new AlunoDao();

        Aluno aluno3 = new Aluno(
            null, "Pedro", "2026003", "pedro@gmail.com"
        );

        try {
            dao.cadastrar(aluno3);

            System.out.println("Pedro cadastrado com sucesso!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}