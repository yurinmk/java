package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conversor extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Valor;
	private JTextField tf_ValorMoeda;
	double euro = 6.05;
	double dolar = 5.59;
	double bitcoin = 42245.74;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Valor = new JLabel("Valor:");
		lbl_Valor.setBounds(10, 11, 48, 14);
		panel.add(lbl_Valor);
		
		tf_Valor = new JTextField();
		tf_Valor.setBounds(68, 8, 114, 20);
		panel.add(tf_Valor);
		tf_Valor.setColumns(10);
		
		JLabel lbl_Resultado = new JLabel("");
		lbl_Resultado.setBounds(68, 96, 96, 14);
		panel.add(lbl_Resultado);
		
		JComboBox comboB_Moedas = new JComboBox();
		comboB_Moedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboB_Moedas.getSelectedItem().equals("Selecionar...")) {
				}else if (comboB_Moedas.getSelectedItem().equals("Euro")) {
					tf_ValorMoeda.setText(Double.toString(euro));
					lbl_Resultado.setText("");
				}else if (comboB_Moedas.getSelectedItem().equals("Dolar")) {
					tf_ValorMoeda.setText(Double.toString(dolar));
					lbl_Resultado.setText("");
				}else if (comboB_Moedas.getSelectedItem().equals("Bitcoin")) {
					tf_ValorMoeda.setText(Double.toString(bitcoin));
					lbl_Resultado.setText("");
				}
			}
		});
		comboB_Moedas.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Euro", "Dolar", "Bitcoin"}));
		comboB_Moedas.setBounds(68, 51, 96, 22);
		panel.add(comboB_Moedas);
		
		
		
		JButton btn_Converter = new JButton("Converter");
		btn_Converter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_Valor.getText().equals("") || tf_ValorMoeda.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Os campos Valor e Moeda são necessários para conversão!");
				}else {
					double resultado = Double.parseDouble(tf_Valor.getText()) / Double.parseDouble(tf_ValorMoeda.getText());
					lbl_Resultado.setText(String.format("%.5f",resultado));
				}
				
			}
		});
		btn_Converter.setBounds(289, 51, 96, 39);
		panel.add(btn_Converter);
		
		JLabel lbl_Moeda = new JLabel("Moeda:");
		lbl_Moeda.setBounds(10, 55, 48, 14);
		panel.add(lbl_Moeda);
		
		tf_ValorMoeda = new JTextField();
		tf_ValorMoeda.setEditable(false);
		tf_ValorMoeda.setBounds(174, 52, 67, 20);
		panel.add(tf_ValorMoeda);
		tf_ValorMoeda.setColumns(10);
		
		JLabel lbl_Total = new JLabel("Total:");
		lbl_Total.setBounds(10, 96, 48, 14);
		panel.add(lbl_Total);
		
		
	}
}
