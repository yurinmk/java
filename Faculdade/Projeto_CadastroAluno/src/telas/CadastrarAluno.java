package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class CadastrarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAluno frame = new CadastrarAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarAluno() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 663, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Nome = new JLabel("Nome:");
		lbl_Nome.setBounds(37, 26, 48, 14);
		panel.add(lbl_Nome);
		
		JLabel lbl_Endereço = new JLabel("Endere\u00E7o:");
		lbl_Endereço.setBounds(17, 51, 59, 14);
		panel.add(lbl_Endereço);
		
		JLabel lbl_Cidade = new JLabel("CIdade:");
		lbl_Cidade.setBounds(31, 76, 48, 14);
		panel.add(lbl_Cidade);
		
		textField = new JTextField();
		textField.setBounds(89, 23, 414, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 48, 414, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 73, 213, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lbl_Estado = new JLabel("Estado:");
		lbl_Estado.setBounds(340, 76, 48, 14);
		panel.add(lbl_Estado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"...", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"}));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(398, 72, 105, 22);
		panel.add(comboBox);
		
		JLabel lbl_Sexo = new JLabel("Sexo:");
		lbl_Sexo.setBounds(41, 101, 48, 14);
		panel.add(lbl_Sexo);
		
		JRadioButton rdb_Masculino = new JRadioButton("Masculino");
		rdb_Masculino.setBackground(Color.LIGHT_GRAY);
		rdb_Masculino.setBounds(99, 100, 109, 23);
		panel.add(rdb_Masculino);
		
		JRadioButton rdb_Feminino = new JRadioButton("Feminino");
		rdb_Feminino.setBackground(Color.LIGHT_GRAY);
		rdb_Feminino.setBounds(210, 100, 109, 23);
		panel.add(rdb_Feminino);
		
		JLabel lbl_Opcoes = new JLabel("Op\u00E7\u00F5es:");
		lbl_Opcoes.setBounds(27, 127, 48, 14);
		panel.add(lbl_Opcoes);
		
		JCheckBox checkb_Curso1 = new JCheckBox("Curso 1");
		checkb_Curso1.setBackground(Color.LIGHT_GRAY);
		checkb_Curso1.setBounds(99, 126, 97, 23);
		panel.add(checkb_Curso1);
		
		JCheckBox checkb_Curso2 = new JCheckBox("Curso 2");
		checkb_Curso2.setBackground(Color.LIGHT_GRAY);
		checkb_Curso2.setBounds(205, 126, 97, 23);
		panel.add(checkb_Curso2);
		
		JCheckBox checkb_Cruso3 = new JCheckBox("Curso 3");
		checkb_Cruso3.setBackground(Color.LIGHT_GRAY);
		checkb_Cruso3.setBounds(310, 126, 97, 23);
		panel.add(checkb_Cruso3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), new Color(128, 128, 128)), "Interesses", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(31, 172, 518, 129);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 204, 95);
		panel_1.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Redes", "Internet", "Compiladores", "Seguran\u00E7a", "BD"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnNewButton_4 = new JButton(">>");
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(224, 23, 54, 23);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("<<");
		btnNewButton_4_1.setForeground(Color.RED);
		btnNewButton_4_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4_1.setBounds(224, 52, 54, 23);
		panel_1.add(btnNewButton_4_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(288, 20, 220, 98);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(548, 22, 105, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gravar");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(548, 56, 105, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Consultar");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(548, 90, 105, 29);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(548, 123, 105, 29);
		panel.add(btnNewButton_3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), new Color(128, 128, 128)), "Observa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(31, 305, 518, 129);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 21, 498, 97);
		panel_1_1.add(scrollPane_2);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
	}
}
