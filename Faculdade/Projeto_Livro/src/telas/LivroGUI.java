package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import modelo.Livro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LivroGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Titulo;
	private JTextField tf_Paginas;
	int index = 0;
	Livro[] lista = new Livro[200];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivroGUI frame = new LivroGUI();
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
	public LivroGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		panel.setBounds(10, 11, 495, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Titulo = new JLabel("T\u00EDtulo:");
		lbl_Titulo.setBackground(Color.BLACK);
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Titulo.setBounds(10, 11, 48, 14);
		panel.add(lbl_Titulo);
		
		JLabel lbl_Paginas = new JLabel("P\u00E1ginas(qnt):");
		lbl_Paginas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Paginas.setBounds(10, 46, 91, 14);
		panel.add(lbl_Paginas);
		
		tf_Titulo = new JTextField();
		tf_Titulo.setBounds(99, 8, 203, 20);
		panel.add(tf_Titulo);
		tf_Titulo.setColumns(10);
		
		tf_Paginas = new JTextField();
		tf_Paginas.setBounds(99, 43, 138, 20);
		panel.add(tf_Paginas);
		tf_Paginas.setColumns(10);
		
		JPanel panel_Lista = new JPanel();
		panel_Lista.setBackground(Color.GRAY);
		panel_Lista.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		panel_Lista.setBounds(10, 101, 495, 218);
		contentPane.add(panel_Lista);
		panel_Lista.setLayout(null);
		
		JList list_Lista = new JList();
		list_Lista.setBounds(10, 11, 475, 196);
		panel_Lista.add(list_Lista);
		
		JButton btn_Add = new JButton("Adicionar");
		btn_Add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(tf_Titulo.getText().equals("") || tf_Paginas.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Os campos são obrigatórios!");
				}else {
					String titulo = tf_Titulo.getText();
					int paginas = Integer.parseInt(tf_Paginas.getText());
					Livro novoLivro = new Livro(titulo, paginas);
					lista[index] = novoLivro;
					index++;
					}
					tf_Titulo.setText("");
					tf_Paginas.setText("");
				}
		});
		btn_Add.setBounds(396, 11, 89, 23);
		panel.add(btn_Add);
		
		JButton btn_Listar = new JButton("Listar");
		btn_Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel dtm = new DefaultListModel();
				for(Livro x: lista) {
					dtm.addElement(x);
					list_Lista.setModel(dtm);	
				}
			}
		});
		btn_Listar.setBounds(396, 46, 89, 23);
		panel.add(btn_Listar);
		
		
	}
}
