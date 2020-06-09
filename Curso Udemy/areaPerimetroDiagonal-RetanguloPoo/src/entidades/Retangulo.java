package entidades;

public class Retangulo {
	
	public double altura;
	public double largura;
	
	public double area() {
		return altura * largura;
	}
	public double perimetro() {
		return 2 * (largura + altura);
	}
	public double diagonal() {
		return Math.sqrt(Math.pow(largura, 2) + Math.pow(altura, 2));
	}
	public String toString() {
		return "AREA = " + String.format("%.2f\n", area()) + "PERIMETRO = " + String.format("%.2f\n", perimetro()) +"DIAGONAL = " + String.format("%.2f\n", diagonal());
	}

}
