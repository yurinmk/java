package entidade;

import java.util.Date;

import entidade.enums.StatusPedido;

public class Pedido {
	
	private Integer id;
	private Date instantePedido;
	private StatusPedido status;
	
	public Pedido() {
	}

	public Pedido(Integer id, Date instantePedido, StatusPedido status) {
		this.id = id;
		this.instantePedido = instantePedido;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstantePedido() {
		return instantePedido;
	}

	public void setInstantePedido(Date instantePedido) {
		this.instantePedido = instantePedido;
	}

	public StatusPedido getPedido() {
		return status;
	}

	public void setPedido(StatusPedido status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", instantePedido=" + instantePedido + ", pedido=" + status + "]";
	}
	
	

}
