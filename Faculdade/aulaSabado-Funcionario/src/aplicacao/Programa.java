package aplicacao;

import javax.swing.JOptionPane;

import entidade.Funcionario;

public class Programa {

	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Nome do Funcionário:");
		String departamento = JOptionPane.showInputDialog("Departamento:");
		String data = JOptionPane.showInputDialog("Data de admissão:");
		String rg = JOptionPane.showInputDialog("RG:");
		double salario = Double.parseDouble(JOptionPane.showInputDialog("Salário:"));
		Funcionario funcionario = new Funcionario(nome, departamento, data, rg, salario);

		JOptionPane.showMessageDialog(null, funcionario);
		double aumento = Double.parseDouble(JOptionPane.showInputDialog("Porcentagem do aumento:"));
		JOptionPane.showMessageDialog(null, "Aumento do Salário: " + funcionario.receberAumento(aumento));

	}

}
