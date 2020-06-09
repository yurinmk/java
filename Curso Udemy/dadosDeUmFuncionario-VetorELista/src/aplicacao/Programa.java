package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> lista = new ArrayList<>();
		Funcionario funcionario = null;
		
		System.out.print("V�o ser registrado quantos funcion�rios? ");
		int qntd = sc.nextInt();
		System.out.println();
		
		
		for(int i = 0; i < qntd; i++) {
		System.out.println("Funcion�rio #" + (i+1) + ":");
		System.out.print("Id: ");
		int idDoFuncionario = sc.nextInt();
		sc.nextLine();
		System.out.print("Nome: ");
		String nomeDoFuncionario = sc.nextLine();
		System.out.print("Sal�rio: ");
		double salarioDoFuncionario = sc.nextDouble();
		funcionario = new Funcionario(idDoFuncionario, nomeDoFuncionario, salarioDoFuncionario);
		lista.add(funcionario);
		System.out.println();
		
		}
		System.out.print("Insira a ID do funcion�rio que ter� aumento salarial: ");
		int idDoFuncionario = sc.nextInt();
		Funcionario temp = lista.stream().filter(x -> x.getIdDoFuncioanrio() == idDoFuncionario).findFirst().orElse(null);
		if(temp != null) {
			System.out.print("Entre com a porcentagem: ");
			double acrescimo = sc.nextDouble();
			temp.acrescimoSalarioal(acrescimo);
		}else {
			System.out.println("ID n�o existente!");
		}
		System.out.println();
		System.out.println("Lista de funcion�rios:");
		for(Funcionario x : lista) {
			System.out.println(x);
		}
		
		
		sc.close();

	}

}
