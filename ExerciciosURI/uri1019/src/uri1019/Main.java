package uri1019;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int horas = x / 3600;
		int minutos = (x % 3600) / 60;
		int segundos = (x % 3600) % 60;
		System.out.println(horas + ":" + minutos + ":" + segundos);
		
		
		sc.close();

	}

}
