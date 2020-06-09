package aplicacao;

import javax.swing.JOptionPane;

import entidade.Moldura;
import entidade.Retangulo;

public class Programa {

	public static void main(String[] args) {
		
		Moldura moldura;
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Altura:"));
		int base = Integer.parseInt(JOptionPane.showInputDialog("Largura:"));
		int espessura = Integer.parseInt(JOptionPane.showInputDialog("Espessura:"));
		Retangulo re = new Retangulo(base, altura);
		Retangulo ri = new Retangulo(base-2*espessura, altura-2*espessura);
		moldura = new Moldura(re, ri);
		JOptionPane.showMessageDialog(null, "Área da moldura: " + moldura.areaMoldura() +" cm²");
		
		
		
		
		
	

	}

}
