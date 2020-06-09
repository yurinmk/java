package entidade;

public class Circulo {

	public double raio;

	public Circulo(double raio) {
		this.raio = raio;
	}

	public double areaCirculo() {
		return Math.PI * Math.pow(this.raio, 2);
	}

	public void area(double raio) {
		this.raio = Math.PI * Math.pow(raio, 2);
	}

}
