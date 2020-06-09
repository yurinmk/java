package entidade;

public class LampadaTresEstados {

	public boolean ligar;
	public boolean desligar;
	public int meioAcesa;

	public void ligarLampada() {
		this.ligar = true;
		this.desligar = false;
	}

	public void desligarLampada() {
		this.desligar = true;
		this.ligar = false;
	}

	public boolean estadoDaLampada() {
		boolean temp;
		if (this.ligar == true) {
			temp = true;
		} else {
			temp = false;
		}
		return temp;
	}

}
