import javax.swing.JOptionPane;

import entidade.Contato;
import entidade.Agenda;

public class Main {

	public static void main(String[] args) {
		Agenda contato = new Agenda();
		for(int i = 0; i<2; i++) {
			String nome = JOptionPane.showInputDialog("Nome:");
			int telefone = Integer.parseInt(JOptionPane.showInputDialog("Telefone:"));
			Contato agenda = new Contato(nome, telefone);
			contato.cadastrarContato(agenda);
		}
		JOptionPane.showMessageDialog(null, contato.mostrarContatos(), "Agenda", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
