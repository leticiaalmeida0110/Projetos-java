
package dao;

import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;

public class AlunoDao {


    public void cadastrar(Aluno aluno)
            throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO aluno "
                + "(nome_aluno, matricula_aluno, email_aluno) "
                + "VALUES (?, ?, ?)";

        PreparedStatement comandoSql =
                Conexao.getInstance().prepareStatement(sql);

        comandoSql.setString(1, aluno.getNome());
        comandoSql.setString(2, aluno.getMatricula());
        comandoSql.setString(3, aluno.getEmail());

        comandoSql.execute();

        Conexao.getInstance().commit();        
    }
}
