package aplicacao;

import javax.swing.JOptionPane;

import entidade.Funcionario;

public class Programa {

	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Nome do Funcion�rio:");
		String departamento = JOptionPane.showInputDialog("Departamento:");
		String data = JOptionPane.showInputDialog("Data de admiss�o:");
		String rg = JOptionPane.showInputDialog("RG:");
		double salario = Double.parseDouble(JOptionPane.showInputDialog("Sal�rio:"));
		Funcionario funcionario = new Funcionario(nome, departamento, data, rg, salario);

		JOptionPane.showMessageDialog(null, funcionario);
		double aumento = Double.parseDouble(JOptionPane.showInputDialog("Porcentagem do aumento:"));
		JOptionPane.showMessageDialog(null, "Aumento do Sal�rio: " + funcionario.receberAumento(aumento));

	}

}
