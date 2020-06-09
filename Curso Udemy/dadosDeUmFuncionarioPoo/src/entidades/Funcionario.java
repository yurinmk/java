package entidades;

public class Funcionario {
	
	
	public String nomeDoFuncionario;
	public double salarioBruto;
	public double imposto;
	
	public double salarioLiquido() {
		return salarioBruto - imposto;
	}
	public void porcentagemDeAcrescimo(double porcentagem) {
		salarioBruto = salarioBruto * (porcentagem/100) + salarioBruto;
	}
	public String toString() {
		return nomeDoFuncionario + ", $ " + String.format("%.2f", salarioLiquido());
	}
}
