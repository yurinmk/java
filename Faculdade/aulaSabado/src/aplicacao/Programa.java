package aplicacao;

import java.util.Scanner;

import javax.swing.JOptionPane;

import entidade.Aluno;



public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*Aluno a1 = new Aluno("Yuri", "Rua MJ23","07500000000", 2300);
		System.out.println(a1);*/
		
		/*String nome = sc.next();
		
		String endereco = sc.next();
		
		String cpf = sc.next();
		
		int matricula = sc.nextInt();
		Aluno a2 = new Aluno(nome, endereco, cpf, matricula);
		System.out.println(a2);
		sc.close();*/
		
		String nome = JOptionPane.showInputDialog("Nome: ");
		int matricula = Integer.parseInt(JOptionPane.showInputDialog("Matrícula: "));
		String cpf = JOptionPane.showInputDialog("CPF: ");
		String endereco= JOptionPane.showInputDialog("Endereço: ");
		Aluno a3 = new Aluno(nome, endereco, cpf, matricula);
		
		JOptionPane.showMessageDialog(null, a3);
		
		
	}

}
