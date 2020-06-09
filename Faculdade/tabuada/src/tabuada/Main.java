package tabuada;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		int entrada;
		entrada = Integer.parseInt(JOptionPane.showInputDialog("Entre com um valor: "));
		
		JOptionPane.showMessageDialog(null, "Tabiada de " + entrada + gerarTabuada(entrada));

	}

	public static String gerarTabuada(int valor) {
		String retorno = "";
		for (int i = 0; i < 11; i++) {
			retorno = retorno + "\n" + valor + " x " + i + " = " + (valor * i);
		}
		return retorno;

	}

}
