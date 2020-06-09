package entidade;

public class Supermercado {

	public String produto;
	public double preco;
	public int quantidade;

	public Supermercado() {
	}

	public Supermercado(String produto, double preco, int quantidade) {
		this.produto = produto;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public void retiradaEstoque(int qnt) {
		this.quantidade -= qnt;
	}

	public double valorTotal(int qnt) {
		return this.preco * qnt;
	}

	@Override
	public String toString() {
		return "Produto: " + produto + ", Preço: R$ " + String.format("%.2f", preco) + ", Quantidade em estoque: "
				+ quantidade + "\n";

	}

}
