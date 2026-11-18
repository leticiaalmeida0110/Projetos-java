package br.edu.ifsul.agenda.contato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{
	//<informar a classe do repositório, e o tipo de dado do id>
}
