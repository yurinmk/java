package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Employee;
import entities.OutsoucerdEmployee;

public class Program {

	public static void main(String[] args) {
		List<Employee> lista = new ArrayList<>();
		
		int entrada = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of employees"));
		
		for(int i = 1; i <= entrada; i++) {
			String x = JOptionPane.showInputDialog("Employee #"+ i + " data:\nOutsourced (y/n)?");
				String name = JOptionPane.showInputDialog("Name:");
				int hours = Integer.parseInt(JOptionPane.showInputDialog("Hours:"));
				double valuePerHour = Double.parseDouble(JOptionPane.showInputDialog("Value per hour:"));
				if (x.equalsIgnoreCase("y")) {
					double additionalCharge = Double.parseDouble(JOptionPane.showInputDialog("Additional charge:"));
					lista.add(new OutsoucerdEmployee(name, hours, valuePerHour, additionalCharge));
				}else {
					lista.add(new Employee(name, hours, valuePerHour));
				}
		}
		String temp = "";
		for (Employee x : lista) {
			temp += x.getName() + " - $ " +  x.payment() +"\n";
		}
		JOptionPane.showMessageDialog(null, "PAYMENTS:\n" + temp);
	}

}
