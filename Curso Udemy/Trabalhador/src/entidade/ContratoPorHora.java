package entidade;

import java.util.Date;

public class ContratoPorHora {

	private Date data;
	private Double valorPorHora;
	private Integer hora;

	public ContratoPorHora() {
		// TODO Auto-generated constructor stub
	}

	public ContratoPorHora(Date data, Double valorPorHora, Integer hora) {

		this.data = data;
		this.valorPorHora = valorPorHora;
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}
	
	//A delegação de que quem deve saber o valor total de um contrato 
	//é a própria classe contarto
	public double valorTotal() {
		return this.valorPorHora * this.hora;
	}

}
