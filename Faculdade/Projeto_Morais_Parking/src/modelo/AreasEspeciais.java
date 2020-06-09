package modelo;

import java.util.Date;

public class AreasEspeciais {
	
	private int id;
	private String bloco;
	private String acesso;
	private Date dataInicio;
	private Date dataFim;
	private String indeterminado;
	private String descricao;
	private int totalVagas;
	private String status;
	
	
	public AreasEspeciais(String bloco, String acesso, Date dataInicio, Date dataFim, String indeterminado,String descricao,
			int totalVagas) {
		this.bloco = bloco;
		this.acesso = acesso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.indeterminado = indeterminado;
		this.descricao = descricao;
		this.totalVagas = totalVagas;
		
	}
	
	public AreasEspeciais(String bloco, String acesso, Date dataInicio, Date dataFim, String indeterminado,String descricao,
			int totalVagas,String status) {
		this.bloco = bloco;
		this.acesso = acesso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.indeterminado = indeterminado;
		this.descricao = descricao;
		this.totalVagas = totalVagas;
		this.status = status;
	}
	
	public AreasEspeciais() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public String getAcesso() {
		return acesso;
	}
	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public String getIndeterminado() {
		return indeterminado;
	}

	public void setIndeterminado(String indeterminado) {
		this.indeterminado = indeterminado;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getTotalVagas() {
		return totalVagas;
	}
	public void setTotalVagas(int totalVagas) {
		this.totalVagas = totalVagas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
