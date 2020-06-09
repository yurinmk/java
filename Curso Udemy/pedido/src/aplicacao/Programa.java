package aplicacao;

import java.util.Date;

import entidade.Pedido;
import entidade.enums.StatusPedido;

public class Programa {

	public static void main(String[] args) {
		Pedido pedido = new Pedido(10000, new Date(), StatusPedido.AGUARDANDO_PAGAMENTO);
		
		System.out.println(pedido);
		
		StatusPedido p1 = StatusPedido.ENTREGUE;
		
		StatusPedido p2 = StatusPedido.valueOf("ENTREGUE");
		
		System.out.println(p1);
		System.out.println(p2);

	}

}
