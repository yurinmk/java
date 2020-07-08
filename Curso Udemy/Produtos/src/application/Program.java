package application;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws HeadlessException, ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> lista = new ArrayList<>();
		int entrada = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of products"));
		
		for (int i = 1; i <= entrada; i++) {
			String x = JOptionPane.showInputDialog("Common, used or imported (c / u / i)?");
			String name = JOptionPane.showInputDialog("Name:");
			Double price = Double.parseDouble(JOptionPane.showInputDialog("Price:"));
			if(x.equalsIgnoreCase("i")) {
				Double customsFee = Double.parseDouble(JOptionPane.showInputDialog("Customs fee:"));
				lista.add(new ImportedProduct(name, price, customsFee));
			}else if(x.equalsIgnoreCase("u")) {
				Date manufactureDate = sdf.parse(JOptionPane.showInputDialog("Manufacture date (DD/MM/YYYY):"));
				lista.add(new UsedProduct(name, price, manufactureDate));
			}else {
				lista.add(new Product(name, price));
			}
		}
		String temp = "";
		for(Product y : lista) {
			temp += y.priceTag() + "\n";
		}
		JOptionPane.showMessageDialog(null, "PRICE TAGS:\n" + temp);
		
		
	}

}
