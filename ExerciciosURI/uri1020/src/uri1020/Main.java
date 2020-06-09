package uri1020;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dias = sc.nextInt();
		
		int ano,mes,dia;
		
		ano = dias / 365;
		mes = (dias % 365) / 30;
		dia = (dias % 365) % 30;
		
		System.out.println(ano + " ano(s)");
		System.out.println(mes + " mes(es)");
		System.out.println(dia + " dia(s)");

		sc.close();

	}

}
