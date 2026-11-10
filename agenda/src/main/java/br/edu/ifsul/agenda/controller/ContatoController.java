package br.edu.ifsul.agenda.controller;

//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsul.agenda.contato.DadosCadastroContato;

@RestController
@RequestMapping("contato")

public class ContatoController {
	
	@PostMapping //metodo POST
	// @RequestBody é o corpo da requisição
	public void cadastrar(@RequestBody DadosCadastroContato dados) {
		System.out.println(dados);
	}
}