package aula.poo;

public class Principal {

	public static float calcularMedia(float n1, float n2) {
		return (n1 + n2) / 2;
	}

	public static void main(String[] args) {
		float x1 = 10, x2 = 5, media;
		int numFalta = 2;
		media = calcularMedia(x1,x2);
		System.out.println(media);
		// Interface para aparecer a média
		// JOptionPane.showMessageDialog(null, "Média: " + media);
		if (media < 5 || numFalta >= 15) {
			System.out.println("Reprovado");

		} else {
			System.out.println("Aprovado");
		}
	}

}
