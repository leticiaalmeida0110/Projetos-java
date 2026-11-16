package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor  
public class Aluno {

    private Integer id;
    private String nome;
    private String matricula;
    private String email;

}

/*no banco de dados
CREATE TABLE aluno (
    id_aluno INT AUTO_INCREMENT PRIMARY KEY,
    nome_aluno VARCHAR(100),
    matricula_aluno VARCHAR(20),
    email_aluno VARCHAR(100)
);

SELECT * FROM aluno;

DELETE FROM aluno
WHERE id_aluno = 2;

ALTER TABLE aluno
ADD CONSTRAINT uk_matricula UNIQUE (matricula_aluno);
*/


/*Passo a passo para fazer exercício de Lombok na prova
Vou seguir o mesmo estilo do exercício de Hibernate, separando por etapas para você conseguir fazer sozinha na prova.

A principal diferença é que, no exercício de Lombok, você vai trabalhar principalmente com anotações que geram métodos automaticamente, sem precisar escrever getters, setters e construtores manualmente.
1. Verificar o pom.xml
Antes de começar, confira se o Lombok já está no projeto.

Procure no pom.xml:
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.36</version>
    <scope>provided</scope>
</dependency>


- Se já existir, não precisa adicionar novamente.
- Se não existir, adicione dentro de dependencies.
2. Criar a classe Aluno
Crie Aluno.java dentro do pacote model (ou modelo, conforme o enunciado).

Atributos:
Atributo	Tipo
id	Integer
nome	String
matricula	String
email	String
curso	String

Utilize as anotações do Lombok:
package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Aluno {

    private Integer id;
    private String nome;
    private String matricula;
    private String email;
    private String curso;

}


O que cada anotação faz?
Anotação	Função
@Getter	Cria os getters
@Setter	Cria os setters
@AllArgsConstructor	Cria construtor com todos os atributos
@NoArgsConstructor	Cria construtor vazio
@ToString	Cria método para exibir os dados

3. Adicionar as anotações do Hibernate/JPA
Como o exercício também pede Hibernate, a classe precisa das anotações JPA.

Adicione os imports:
import jakarta.persistence.*;


E coloque as anotações nos atributos:
@Entity
@Table(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(unique = true)
    private String matricula;

    private String email;
    private String curso;
}


Atenção para a prova:
- @Entity: transforma a classe em entidade do banco.
- @Table: define o nome da tabela.
- @Id: define a chave primária.
- @GeneratedValue: gera o ID automaticamente.
- @Column(unique = true): impede matrícula repetida.
- Lombok gera os métodos automaticamente.
4. Criar um objeto usando Lombok
No arquivo TesteAluno.java, você pode criar um aluno assim:
Aluno aluno = new Aluno(
    null,
    "Ana",
    "2026001",
    "ana@gmail.com",
    "Ciência da Computação"
);


Por que o ID é null?

Porque ele será gerado automaticamente pelo banco de dados.

Como temos @AllArgsConstructor, não precisamos criar o construtor manualmente.

Para alterar o email:
aluno.setEmail("novo@gmail.com");


Para consultar o nome:
aluno.getNome();


Para exibir os dados:
System.out.println(aluno);


Esses métodos são gerados pelo Lombok.
5. Criar o AlunoDao
O DAO é responsável pelas operações no banco de dados. O Lombok não faz essa parte: quem trabalha com isso é o Hibernate/JPA.

Crie AlunoDao.java dentro do pacote dao.
package dao;

import jakarta.persistence.*;
import model.Aluno;
import java.util.List;

public class AlunoDao {

    private EntityManager em;

    public AlunoDao(EntityManager em) {
        this.em = em;
    }

    // Cadastrar
    public void cadastrar(Aluno aluno) {
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
    }

    // Atualizar
    public void atualizar(Aluno aluno) {
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
    }

    // Remover
    public void remover(Integer id) {
        em.getTransaction().begin();

        Aluno aluno = em.find(Aluno.class, id);

        if (aluno != null) {
            em.remove(aluno);
        }

        em.getTransaction().commit();
    }

    // Buscar por ID
    public Aluno buscarPorId(Integer id) {
        return em.find(Aluno.class, id);
    }

    // Buscar todos
    public List<Aluno> buscarTodos() {
        return em.createQuery(
            "SELECT a FROM Aluno a", Aluno.class
        ).getResultList();
    }

    // Buscar por nome
    public List<Aluno> buscarPorNome(String nome) {
        return em.createQuery(
            "SELECT a FROM Aluno a WHERE a.nome LIKE :nome",
            Aluno.class
        ).setParameter("nome", "%" + nome + "%")
         .getResultList();
    }
}


Decore esta tabela para a prova:
Operação	Comando
Cadastrar	persist()
Atualizar	merge()
Excluir	find() + remove()
Buscar por ID	find()
Buscar todos	createQuery()
Buscar por nome	createQuery() + setParameter()

6. Criar a classe TesteAluno
Crie TesteAluno.java dentro do pacote testes.
package testes;

import dao.AlunoDao;
import model.Aluno;
import utils.JPAUtils;
import jakarta.persistence.*;

public class TesteAluno {

    public static void main(String[] args) {

        EntityManager em = JPAUtils.getEntityManager();

        AlunoDao dao = new AlunoDao(em);

        // Cadastrar Ana
        Aluno ana = new Aluno(
            null, "Ana", "2026001",
            "ana@gmail.com", "Ciência da Computação"
        );

        dao.cadastrar(ana);

        // Cadastrar Pedro
        Aluno pedro = new Aluno(
            null, "Pedro", "2026002",
            "pedro@gmail.com", "Ciência da Computação"
        );

        dao.cadastrar(pedro);

        // Buscar todos
        System.out.println(dao.buscarTodos());

        // Buscar por ID
        System.out.println(dao.buscarPorId(1));

        // Atualizar email
        ana.setEmail("ana2@gmail.com");
        dao.atualizar(ana);

        // Buscar por nome
        System.out.println(dao.buscarPorNome("Ana"));

        // Excluir Pedro
        dao.remover(pedro.getId());

        em.close();
    }
}


7. Conferir o persistence.xml
Dentro de src/main/resources/META-INF/persistence.xml, confira se existe:
<class>model.Aluno</class>


Se o pacote for modelo, coloque:
<class>modelo.Aluno</class>


Confira também se a conexão com o MySQL já está configurada e se existe:
<property name="hibernate.hbm2ddl.auto" value="update"/>


8. Conferir se o Lombok está funcionando
Se aparecer erro nos métodos getNome(), setNome() ou no construtor, confira:
1. Se a dependência do Lombok está no pom.xml.
2. Se os imports estão corretos.
3. Se o processamento de anotações está habilitado no ambiente de desenvolvimento.
4. Se o projeto foi atualizado pelo Maven.

9. Resumo para memorizar na prova
ORDEM PARA FAZER O EXERCÍCIO
1. pom.xml: verificar dependência do Lombok.
2. Aluno.java: criar atributos e colocar anotações.
3. JPA: adicionar @Entity, @Id, @GeneratedValue e outras anotações.
4. persistence.xml: adicionar a classe.
5. AlunoDao: criar os métodos de cadastro, consulta, atualização e exclusão.
6. TesteAluno: criar objetos e testar os métodos.

10. Cola rápida: qual anotação usar?
Se o enunciado pedir...	Você usa...
Gerar getter	@Getter
Gerar setter	@Setter
Construtor completo	@AllArgsConstructor
Construtor vazio	@NoArgsConstructor
Exibir os atributos	@ToString
Chave primária	@Id
ID automático	@GeneratedValue
Valor único	@Column(unique = true)
Transformar em entidade	@Entity

O mais importante para não confundir:
- Lombok = gera métodos automaticamente.
- JPA = fornece as anotações para mapear as classes e os atributos.
- Hibernate = implementa o mapeamento e facilita as operações com o banco de dados.
- DAO = contém os métodos de cadastro, consulta, atualização e exclusão.
- Teste = executa os métodos para verificar se funcionam.
Dica para a prova: se você já souber criar a classe com Lombok, a parte principal é lembrar quais anotações colocar e como utilizar o construtor, os getters e os setters.
 */
