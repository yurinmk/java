package exercicioJava;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	
	public static void equacaoSegundoGrau(double valorA,double valorB,double valorC) {
		double delta,x1,x2;
				
		delta = Math.pow(valorB, 2) - (4 * valorA * valorC);
		x1 = (-valorB + Math.sqrt(delta)) / (2*valorA);
		x2 = (-valorB - Math.sqrt(delta)) / (2*valorA);
		
		//JOptionPne que apresenta uma mensagem
		JOptionPane.showMessageDialog(null, "Valor de delta: " + delta + "\n" + "Valor positivo de x: " + x1 + "\n" + "Valor negativo de x: " + x2);
	}

	public static void main(String[] args) {
		
		double a,b,c;
		
		/* Resolvido com o Scanner
		Scanner sc = new Scanner(System.in);
		
		double a,b,c,delta,x1,x2;
				
		
		System.out.println("Número que representa A: ");
		a = sc.nextDouble();
		System.out.println("Número que representa B: ");
		b = sc.nextDouble();
		System.out.println("Número que representa C: ");
		c = sc.nextDouble();
		
		delta = Math.pow(valorB, 2) - (4 * valorA * valorC);
		x1 = (-valorB + Math.sqrt(delta)) / (2*valorA);
		x2 = (-valorB - Math.sqrt(delta)) / (2*valorA);
		System.out.println("Valor de delta: " + delta);
		
		System.out.println("Valor de x1: " + x1);
		System.out.println("Valor de x2: " + x2);
		sc.close();*/
		
		// Resolvido com JOptionPane
		//JOptionPane que armazena um String e Double.parseDouble converte o String em double
		a = Double.parseDouble(JOptionPane.showInputDialog(null, "Número que representa A: "));		
		b = Double.parseDouble(JOptionPane.showInputDialog(null, "Número que representa B: "));		
		c = Double.parseDouble(JOptionPane.showInputDialog(null, "Número que representa C: "));
		equacaoSegundoGrau(a, b, c);
		

	}

}
