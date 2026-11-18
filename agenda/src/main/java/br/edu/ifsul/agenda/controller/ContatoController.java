package br.edu.ifsul.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsul.agenda.contato.Contato;
import br.edu.ifsul.agenda.contato.ContatoRepository;
import br.edu.ifsul.agenda.contato.DadosCadastroContato;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("contato")

public class ContatoController {
	@Autowired // cria o repositorio com questoes de BD automaticamente
	private ContatoRepository repository;
	
	@PostMapping //metodo POST
	@Transactional // faz alteração no BD
	// @RequestBody é o corpo da requisição
	public void cadastrar(@RequestBody @Valid DadosCadastroContato dados) {
		System.out.println(dados);
		Contato c = new Contato (dados);
		this.repository.save(c);
		}
}