package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Aluno;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Aluno entrada;
		
		entrada = new Aluno();
		
		entrada.nome = sc.nextLine();
		entrada.nota1 = sc.nextDouble();
		entrada.nota2 = sc.nextDouble();
		entrada.nota3 = sc.nextDouble();
		
		entrada.resultadoAluno();
		
		sc.close();

	}

}
