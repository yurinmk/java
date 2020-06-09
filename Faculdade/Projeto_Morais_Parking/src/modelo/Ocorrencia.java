package modelo;

import java.sql.Date;

public class Ocorrencia {
	
	private String ocorrencia;
	private String matricula;
	private String nome;
	private String placa;
	private String marca;
	private String tipo;
	private Date data;
	private String hora;
	private String local;
	private double idOcorrencia;
	
	public Ocorrencia() {
		// TODO Auto-generated constructor stub
	}
	
	public Ocorrencia(String placa, String ocorrencia, String matricula, String nome, String marca, String tipo,String local,double idOcorrencia) {
		this.ocorrencia = ocorrencia;
		this.matricula = matricula;
		this.nome = nome;
		this.placa = placa;
		this.marca = marca;
		this.tipo = tipo;
		this.local = local;
		this.idOcorrencia = idOcorrencia;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}
	
	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public double getIdOcorrencia() {
		return idOcorrencia;
	}

	public void setIdOcorrencia(double idOcorrencia) {
		this.idOcorrencia = idOcorrencia;
	}
	
	
	
	

}
