package model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="alunos")
public class Aluno {
	// chave primaria
	@Id
	// gera chaves automaticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome; // pode repetir

    @Column(unique = true)
	private String matricula;
	
	@Column(unique = true)
	private String email;

	private String curso;
	
	//@ManyToOne usaria se fosse usar um relacionamento de curso e aluno por exemplo
	//@ManyToOne
    //@JoinColumn(name="id_curso")
    //private Curso curso;
    
    //@JoinColumn(name="id_categoria")
	//private Categoria categoria;
	
    /*Exercício prático – Gerenciamento de Alunos
Nível iniciante
 Estilo prova

banco de dados

USE aula_hibernate;

SELECT * FROM alunos; #ver todos os alunos
SELECT * FROM alunos WHERE id = 1; #buscar pelo id
SELECT * FROM alunos WHERE nome LIKE 'Pedro'; #buscar pelo nome
SELECT * FROM alunos WHERE id = 1; #verificar alteração


Enunciado:

Uma instituição de ensino precisa de um sistema para gerenciar seus alunos utilizando Java, Hibernate, JPA e MySQL.

Você deverá implementar as funcionalidades de cadastro, consulta, atualização e exclusão de alunos.
1. Criar a classe Aluno
Crie uma classe chamada Aluno.java, dentro do pacote modelo. IGUAL

Ela deverá possuir os seguintes atributos:
Atributo	Tipo
id	Integer
nome	String
matricula	String
email	String
curso	String

Requisitos:
- O ID deve ser chave primária e gerado automaticamente.  IGUAL
- A matrícula deve ser única. IGUAL
- A classe deve representar uma tabela chamada alunos. IGUAL
- Utilize as anotações JPA.
2. Configurar o persistence.xml
Adicione a classe Aluno no arquivo persistence.xml, assim como já acontece com Contato e Categoria.
EX:         <class>model.Aluno</class>
Ver se tem isso no computador
 <properties>
            <!-- Conexão JDBC MySQL -->
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/aula_hibernate?useSSL=false&amp;serverTimezone=UTC&amp;allowPublicKeyRetrieval=true" />
            <property name="jakarta.persistence.jdbc.user" value="root" />
            <property name="jakarta.persistence.jdbc.password" value="Bancodedados123" />

            <!-- Configurações do Hibernate -->
            <property name="hibernate.show_sql" value="true" />       <!-- Mostrar SQL -->
            <property name="hibernate.format_sql" value="true" />     <!-- Formatar SQL -->
            <property name="hibernate.hbm2ddl.auto" value="update" /> <!-- Update automatico -->
        </properties>

3. Criar a classe AlunoDao
Crie AlunoDao.java, dentro do pacote dao.

Implemente os seguintes métodos:
Método	Funcionalidade
cadastrar()	Salvar aluno IGUAL
atualizar()	Alterar dados IGUAL
remover()	Excluir pelo ID IGUAL
buscarPorId()	Buscar aluno pelo ID IGUAL
buscarTodos()	Listar todos os alunos
buscarPorNome()	Buscar aluno pelo nome usando JPQL

Utilize os métodos do Hibernate/JPA que estudamos.
4. Criar a classe TesteAluno
Crie TesteAluno.java, dentro do pacote testes.

Faça os seguintes testes:
1. Cadastrar um aluno chamado Ana, matrícula 2026001, email ana@gmail.com e curso Ciência da Computação.
2. Cadastrar outro aluno chamado Pedro, matrícula 2026002.
3. Listar todos os alunos.
4. Buscar o aluno pelo ID.
5. Atualizar o email da Ana.
6. Buscar alunos pelo nome.
7. Excluir o Pedro.
5. Estrutura esperada
aula_hibernate

 src/main/java

 modelo

Contato.java · Categoria.java · Aluno.java
 dao

CategoriaDao.java · AlunoDao.java
 testes

TesteCategoria.java · TesteAluno.java
 utils

JPAUtils.java

 src/main/resources/META-INF

persistence.xml
 pom.xml



6. Dicas para resolver sem olhar a resposta
Como você já tem Lombok no projeto, pode seguir o mesmo padrão da classe Categoria.java:
- @Getter: gera os getters.
- @Setter: gera os setters.
- @AllArgsConstructor: cria construtor com todos os atributos.
- @NoArgsConstructor: cria construtor vazio.
- @ToString: gera o método para exibir os dados.
Algumas dicas para o DAO:
Você quer...	Lembre-se de usar...
Cadastrar	persist()
Atualizar	merge()
Excluir	find() e remove()
Buscar por ID	find()
Consultar com JPQL	createQuery()

Não esqueça que cadastro, atualização e exclusão precisam de transação: begin() e commit(). */

}
