package aula_bd;

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
	private int numeroMatricula;
	private String nome;
	private double mediaGeral;
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		a1.setNome("Maria");
		a1.setNumeroMatricula(123);
		a1.setMediaGeral(9.1);
		System.out.println(a1);
	}
}
