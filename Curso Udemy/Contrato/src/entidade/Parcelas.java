package entidade;

import java.util.Date;

public class Parcelas {
	
	private Date dataPagamento;
	private Double valorPagamento;
	
	
	public Parcelas() {
	
	}

	public Parcelas(Date dataPagamento, Double valorPagamento) {
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	
}
