package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Retangulo;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Retangulo entrada;
		
		entrada = new Retangulo();
		System.out.println("Digite a Altura e a Largura de um Retângulo:");
		entrada.altura = sc.nextDouble();
		entrada.largura = sc.nextDouble();
		
		System.out.println(entrada);
		
		sc.close();

	}

}
