package teste;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ExemploDatas {
	
	public static void main(String[] args) {
		// data atual
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		// data específica
		LocalDate data1 = LocalDate.of(2026, 12, 25);
		System.out.println(data1);
		
		// formatando datas
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data2 = LocalDate.parse("15/06/2026", formato);
		System.out.println(data2);
		
		// operações
		hoje = hoje.plusDays(1);
		hoje = hoje.plusMonths(1);
		hoje = hoje.plusYears(1);
		System.out.println(hoje);
		
		// comparações
		LocalDate d1 = LocalDate.of(2026, 6, 15);
		LocalDate d2 = LocalDate.of(2026, 7, 1);
		System.out.println(d1.isBefore(d2)); // true
		System.out.println(d1.isAfter(d2));  // false
		System.out.println(d1.equals(d2));   // false
		
		// periodo entre datass
		Period tempo = Period.between(d1, d2);
		System.out.println(String.format("%d dias, %d meses, %d anos", tempo.getDays(), tempo.getMonths(), tempo.getYears()));
		
	}

}