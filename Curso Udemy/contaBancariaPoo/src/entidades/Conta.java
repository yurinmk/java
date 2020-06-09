package entidades;

public class Conta {

	private String nomeDoCliente;
	private int numeroDaConta;
	private double saldoDaConta;

	

	public Conta(String nomeDoCliente, int numeroDaConta) {
		super();
		this.nomeDoCliente = nomeDoCliente;
		this.numeroDaConta = numeroDaConta;
	}
	public Conta(String nomeDoCliente, int numeroDaConta, double depositoInicial) {
		super();
		this.nomeDoCliente = nomeDoCliente;
		this.numeroDaConta = numeroDaConta;
		deposito(depositoInicial);
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public double getSaldoDaConta() {
		return saldoDaConta;
	}

	public void deposito(double valor) {
		saldoDaConta += valor;
	}

	public void saque(double valor) {
		saldoDaConta -= valor + 5.00;
	}

	public String toString() {
		return "Dados da conta:\nConta: " + getNumeroDaConta() 
		+ ", Titular: " + getNomeDoCliente() 
		+ ", Saldo: $ " + String.format("%.2f", getSaldoDaConta());
	}

}
