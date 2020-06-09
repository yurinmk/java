package entidade;

public class Funcionario {
	public String nomeDoFuncionario;
	public String departamentoDoFuncionario;
	public String dataEntradaBanco;
	public String rgDoFuncionario;
	public double salarioDoFuncionario;
	public Funcionario(String nomeDoFuncionario, String departamentoDoFuncionario, String dataEntradaBanco,
			String rgDoFuncionario, double salarioDoFuncionario) {
		this.nomeDoFuncionario = nomeDoFuncionario;
		this.departamentoDoFuncionario = departamentoDoFuncionario;
		this.dataEntradaBanco = dataEntradaBanco;
		this.rgDoFuncionario = rgDoFuncionario;
		this.salarioDoFuncionario = salarioDoFuncionario;
	}
	public double receberAumento(double aumento) {
		return this.salarioDoFuncionario += (this.salarioDoFuncionario * (aumento/100));
		
	}
	public double salarioAnual() {
		return this.salarioDoFuncionario * 12.0;
	}
	public String toString() {
		return "Nome: " + this.nomeDoFuncionario
				+"\nRG: " + this.rgDoFuncionario
				+"\nData de admiss�o: " + this.dataEntradaBanco
				+"\nDepartamento: " + this.departamentoDoFuncionario
				+"\nSal�rio: " + this.salarioDoFuncionario
				+"\nSal�rio Anual:" + salarioAnual();
	}
	
}
