package application;

import javax.swing.JOptionPane;

import entidade.Library;

public class Program {

	public static void main(String[] args) {
		
		Library x = new Library();
		
		JOptionPane.showMessageDialog(null, x.showPending(), "Students with pending books",JOptionPane.INFORMATION_MESSAGE);
		
	}

}
