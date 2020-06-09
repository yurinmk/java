package entidades;

public class Hotel {
	
	private String nomeDoCliente;
	private String emailDoCliente;
	private int numeroDoquarto;
	public Hotel(String nomeDoCliente, String emailDoCliente, int numeroDoQuarto) {
		this.nomeDoCliente = nomeDoCliente;
		this.emailDoCliente = emailDoCliente;
		this.numeroDoquarto = numeroDoQuarto;
	}
	public String getNomeDoCliente() {
		return nomeDoCliente;
	}
	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}
	public String getEmailDoCliente() {
		return emailDoCliente;
	}
	public void setEmailDoCliente(String emailDoCliente) {
		this.emailDoCliente = emailDoCliente;
	}
	public int getQuartoDoCliente() {
		return numeroDoquarto;
	}
	public void setQuartoDoCliente(int quartoDoCliente) {
		this.numeroDoquarto = quartoDoCliente;
	}
	
	

}
