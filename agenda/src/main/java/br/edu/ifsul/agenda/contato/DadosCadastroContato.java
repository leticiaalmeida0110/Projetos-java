package br.edu.ifsul.agenda.contato;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroContato(
		@NotBlank(message = "O nome deve ser informado.")
		String nome, 
		
		@NotBlank
		@Pattern(regexp = "\\d{8,9}")
		String celular, 
		
		@NotBlank
		@Email
		String email, 
		
		@NotNull
		@Past
		LocalDate dataNascimento) {

}
