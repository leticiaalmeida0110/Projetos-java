
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao;

    private static final String BANCO_DADOS = "aula_bd";
    private static final String LOGIN = "root";
    private static final String SENHA = "Bancodedados123";

    private Conexao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/" + BANCO_DADOS;
        conexao = DriverManager.getConnection(url, LOGIN, SENHA);
        conexao.setAutoCommit(false);
    }

    public static Connection getInstance() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            new Conexao();
        }

        return conexao;
    }
}