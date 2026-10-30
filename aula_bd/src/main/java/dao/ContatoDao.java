package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Contato;

public class ContatoDao {
	
	public void cadastrar(Contato cont) throws ClassNotFoundException, SQLException {
		String sql = "insert into contato (nome_contato, cel_contato, email_contato, "
				+ "data_nasc_contato) values (?, ?, ?, ?)";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cont.getNome());
		comandoSql.setString(2, cont.getCelular());
		comandoSql.setString(3, cont.getEmail());
		
		Date data = Date.valueOf(cont.getDataNascimento());
		comandoSql.setDate(4, data);
		
		comandoSql.execute();
		
		Conexao.getInstance().commit();
	}
	
	public void alterar(Contato cont) throws ClassNotFoundException, SQLException {
		String sql = "update contato set "
				+ "nome_contato=?, cel_contato=?, "
				+ "email_contato=?, data_nasc_contato=? "
				+ "where id_contato=?";
		
		PreparedStatement comandoSql = 
				Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cont.getNome());
		comandoSql.setString(2, cont.getCelular());
		comandoSql.setString(3, cont.getEmail());
		
		Date data = Date.valueOf(cont.getDataNascimento());
		comandoSql.setDate(4, data);
		
		comandoSql.setInt(5, cont.getId());
		
		comandoSql.execute();
		
		Conexao.getInstance().commit();
	}
}