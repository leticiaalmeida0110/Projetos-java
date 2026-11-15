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

// 1. Criar a classe no Model
//Pasta: model
//Criar a classe (ex.: Contato.java).
//- Declarar os atributos.
//- Criar construtor.
//- Criar getters e setters.
//2. Criar a classe no DAO
//Pasta: dao
//- Criar a classe (ex.: ContatoDao.java).
//- Criar os comandos SQL.
//- Implementar os métodos necessários.
//Operação	Comando SQL
//Cadastrar	INSERT INTO
//Listar	SELECT
//Alterar	UPDATE
//Excluir	DELETE

//3. Criar a classe de teste
//Pasta: teste
//- Criar um objeto DAO.
//- Criar um objeto da classe Model.
//- Informar os dados.
//- Chamar o método desejado.
//- Executar o arquivo (Run).
//4. Abrir o MySQL Workbench
//Comandos importantes
//O que fazer	Comando
//Ver bancos existentes	SHOW DATABASES;
//Criar banco	CREATE DATABASE nome_banco;
//Selecionar banco	USE nome_banco;
//Ver tabelas	SHOW TABLES;
//Criar tabela	CREATE TABLE ...;
//Ver estrutura da tabela	DESCRIBE nome_tabela;
//Ver registros	SELECT * FROM nome_tabela;

//5. Se precisar criar o banco e a tabela
//Exemplo:
//CREATE DATABASE aula_bd;

//USE aula_bd;

//CREATE TABLE contato (
  //  id_contato INT AUTO_INCREMENT PRIMARY KEY,
  //  nome_contato VARCHAR(100),
  //  cel_contato VARCHAR(20),
  //  email_contato VARCHAR(100),
  //  data_nasc_contato DATE
//);


//6. Ordem para memorizar na prova
//1. MODEL – Criar a classe e os atributos.
//2. DAO – Criar os métodos e comandos SQL.
//3. TESTE – Criar os objetos e chamar os métodos.
//4. MYSQL – Criar banco e tabela, se não existirem.
//5. EXECUTAR – Rodar o teste no Java.
//6. CONFERIR – Usar SELECT * FROM nome_tabela;.

//Dica para não confundir:
//- CREATE DATABASE = cria o banco.
//- CREATE TABLE = cria a tabela.
//- DESCRIBE = mostra as colunas da tabela.
//- SELECT * = mostra os dados cadastrados.
//- INSERT INTO = cadastra dados.