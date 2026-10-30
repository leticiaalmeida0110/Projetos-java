package teste;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.ContatoDao;
import model.Contato;

public class TesteContato {
	
	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		
		LocalDate data = LocalDate.of(2001, 10, 15);
		Contato cont = new Contato(null, "Ana", "99160-1234",
				"ana@gmail.com", data);
		
		try {
			dao.cadastrar(cont);
			
			System.out.println("Operacao realizada.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}