package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Programa {

	public static void main(String[] args) throws ParseException{
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = Date.from(Instant.parse("1993-12-04T16:40:10Z"));
		System.out.println("Data no formato UTC (3h a menos que no Brasil): " + data.format(d));
		//Calendário
		Calendar cal = Calendar.getInstance();
		//Data d instânciada dentro do calendário
		cal.setTime(d);
		//adiciona 4h a data 1993-12-04T16:40:10Z
		cal.add(Calendar.HOUR_OF_DAY, 4);
		d = cal.getTime();
		System.out.println("Adicionando 4h em um horário: " + data.format(d));
		//Pegar a unidade de tempo de um horário
		int hora = cal.get(Calendar.HOUR_OF_DAY) - 1;
		int minutos = cal.get(Calendar.MINUTE);
		int segundos = cal.get(Calendar.SECOND);
		//Pegar a unidade de um ano
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		//Precisa domar com 1 porque Janeiro começa em 0
		int mes = 1 + cal.get(Calendar.MONTH);
		int ano = cal.get(Calendar.YEAR);
		
		
		
		
		System.out.println("Retornando os segundos de um horário: " + hora);
		System.out.println("Retornando os minutos de um horário: " + minutos);
		System.out.println("Retornando os horas de um horário: " + segundos);
		System.out.println("Retornando o dia de uma data: " + dia);
		System.out.println("Retornando o mês de uma data: " + mes);
		System.out.println("Retornando o ano de uma data: " + ano);
		
		
	}

}
