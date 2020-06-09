package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Circulo;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Circulo c1, c2;

		c1 = new Circulo(sc.nextDouble());
		System.out.println(c1.areaCirculo());
		
		
		double raio = sc.nextDouble();
		c2 = new  Circulo(raio);
		c2.area(raio);
		System.out.println(c2);
		sc.close();
	}
	

}
