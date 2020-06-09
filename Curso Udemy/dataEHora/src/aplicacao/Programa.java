package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Programa {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat data1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat data2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//Inicia um SimpleDateFormat definindo o TimeZone é o GMT (Greenwich) 3h a mais que no Brasil
		SimpleDateFormat data3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		data3.setTimeZone(TimeZone.getTimeZone("GMT"));
		//Instância a data atual
		Date dataAtual1 = new Date();
		//Pega um instante do sistema, converte em miliessegundos e cria a data com esse valor
		Date dataAtual2 = new Date(System.currentTimeMillis());
		
		Date x1 = data1.parse("04/12/1993");
		Date x2 = data2.parse("04/12/1993 16:00:00");
		//"1993-12-04T16:00:00Z" Formato UTC
		Date x3 = Date.from(Instant.parse("1993-12-04T16:00:00Z"));
		
		System.out.println("Horário no Brasil 3h a Menos----------------------");
		System.out.println("Sem formatação: " + x1);
		System.out.println("Sem Formatação: " + x2);
		
		System.out.println("Com formatação: " + data1.format(x1));
		System.out.println("Com Formatação: " + data2.format(x2));

		System.out.println("Data atual com formatação: " + data2.format(dataAtual1));
		System.out.println("Data atual usando System.currentTimeMillis: " + data2.format(dataAtual2));
		System.out.println("Formato UTC formatado no horário do Brasil: " + data2.format(x3));
		System.out.println("Horário no Greenwich 3h a mais----------------------");
		System.out.println("Com formatação: " + data3.format(x1));
		System.out.println("Com Formatação: " + data3.format(x2));

		System.out.println("Data atual com formatação: " + data3.format(dataAtual1));
		System.out.println("Data atual usando System.currentTimeMillis: " + data3.format(dataAtual2));
		System.out.println("Formato UTC formatado no horário do Greenwich: " + data3.format(x3));


	}

}
