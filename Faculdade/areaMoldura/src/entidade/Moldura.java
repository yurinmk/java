package entidade;

public class Moldura {

	Retangulo rExterno;
	Retangulo rInterno;

	public Moldura(Retangulo re, Retangulo ri) {
		this.rExterno = re;
		this.rInterno = ri;
	}

	public double areaMoldura() {
		return this.rExterno.areaRetanguro() - this.rInterno.areaRetanguro();
	}

}
