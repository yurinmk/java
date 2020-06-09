package entidades;

public class Funcionario {

	private Integer idDoFuncionario;
	private String nomeDoFuncionario;
	private Double salarioDoFuncionario;

	public Funcionario(Integer idDoFuncioanrio, String nomeDoFuncionario, Double salarioDoFuncionario) {
		this.idDoFuncionario = idDoFuncioanrio;
		this.nomeDoFuncionario = nomeDoFuncionario;
		this.salarioDoFuncionario = salarioDoFuncionario;
	}

	public Integer getIdDoFuncioanrio() {
		return idDoFuncionario;
	}

	public void setIdDoFuncioanrio(Integer idDoFuncioanrio) {
		this.idDoFuncionario = idDoFuncioanrio;
	}

	public String getNomeDoFuncionario() {
		return nomeDoFuncionario;
	}

	public void setNomeDoFuncionario(String nomeDoFuncionario) {
		this.nomeDoFuncionario = nomeDoFuncionario;
	}

	public Double getSalarioDoFuncionario() {
		return salarioDoFuncionario;
	}

	public void setSalarioDoFuncionario(Double salarioDoFuncionario) {
		this.salarioDoFuncionario = salarioDoFuncionario;
	}
	
	public void acrescimoSalarioal(double valor) {
		salarioDoFuncionario += (salarioDoFuncionario * (valor/100));
	}
	public String toString() {
		return idDoFuncionario + ", " + nomeDoFuncionario + String.format(", %.2f", salarioDoFuncionario);
	}


}
