package exercicioSalarioComDesconto;

import java.util.Scanner;




public class Main {
	
	public static void salario(double valorPorHora, double numHorasTrabalhadas){
		double salarioLiquido, salarioBruto, descontoIPRF, descontoINSS, descontoSindicato, totalDesconto;
		salarioBruto = valorPorHora * numHorasTrabalhadas;
		descontoIPRF = salarioBruto * 0.11;
		descontoINSS = salarioBruto * 0.08;
		descontoSindicato = salarioBruto * 0.05;
		totalDesconto = descontoINSS + descontoIPRF + descontoSindicato;
		salarioLiquido = salarioBruto - totalDesconto;
		System.out.println("Salário Bruto= R$: " + salarioBruto + "\n" + "Quanto pagou de IPRF= R$: " + descontoIPRF + "\n" + "Quanto pagou de INSS= R$: " + descontoINSS);
		System.out.println("Quando pagou de Sindicato= R$: " + descontoSindicato + "\n" + "Salário liqueido= R$: " + salarioLiquido + "\n" + "Valor descontado= R$: " + totalDesconto);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double valorPorHora, numHorasTrabalhadas;
		
		System.out.println("Quando você ganha por hora? ");
		valorPorHora = sc.nextDouble();
		System.out.println("Quantas horas você trabalha? ");
		numHorasTrabalhadas = sc.nextDouble();
		salario(valorPorHora, numHorasTrabalhadas);
	
		
		sc.close();
	}

}
