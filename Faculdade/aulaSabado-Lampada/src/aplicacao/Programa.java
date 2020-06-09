package aplicacao;

import javax.swing.JOptionPane;

import entidade.LampadaTresEstados;

public class Programa {

	public static void main(String[] args) {

		LampadaTresEstados lampada = new LampadaTresEstados();
		Object[] opcao = { "LIGAR", "DESLIGAR", "SAIR" };
		lampada.desligarLampada();

		int resposta = 0;
		while (resposta != 2 && resposta != -1) {

			if (lampada.estadoDaLampada() == true) {
				JOptionPane.showMessageDialog(null, "A luz está acesa!", "Informação da Lâmpada:",
						JOptionPane.INFORMATION_MESSAGE);
				resposta = JOptionPane.showOptionDialog(null, "Você deseja?", "Lâmpada",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
				if (resposta == 1) {
					lampada.desligarLampada();
				}
			} else if (lampada.estadoDaLampada() == false) {
				JOptionPane.showMessageDialog(null, "A luz está apagada!", "Informação da Lâmpada:",
						JOptionPane.INFORMATION_MESSAGE);
				resposta = JOptionPane.showOptionDialog(null, "Você deseja?", "Lâmpada",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
				if (resposta == 0) {
					lampada.ligarLampada();
				}
			}

		}

	}

}
