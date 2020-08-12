package entidade;

import java.util.Date;

public class Contrato {
	
	private Integer numero;
	private Date data;
	private Double valor;
	private int qntParcelas;
	
	public Contrato() {
	}

	public Contrato(Integer numero, Date data, Double valor, int qntParcelas) {
		this.numero = numero;
		this.data = data;
		this.valor = valor;
		this.qntParcelas = qntParcelas;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return data;
	}

	public void setDate(Date date) {
		this.data = date;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQntParcelas() {
		return qntParcelas;
	}

	public void setQntParcelas(int qntParcelas) {
		this.qntParcelas = qntParcelas;
	}

}
