package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import conexao.Conexao;
import conexao.ConexaoAreasEspeciais;
import conexao.ConexaoEventos;
import modelo.AreasEspeciais;
import modelo.Eventos;

public class MonitoramentoAreasEspeciais extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DefaultTableModel dtm = new DefaultTableModel();
	String local;
	int xx;
	int xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonitoramentoAreasEspeciais frame = new MonitoramentoAreasEspeciais();
					frame.setUndecorated(true);
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
	public MonitoramentoAreasEspeciais() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.POPUP);
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 702, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(208, 50, 47));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 706, 27);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_Sair = new JButton("");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btn_Sair.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/fechar.png")));
		btn_Sair.setBounds(666, 3, 16, 16);
		panel.add(btn_Sair);
		
		JLabel lblCadastroDeEventos = new JLabel("Monitoramento de \u00C1reas Especiais");
		lblCadastroDeEventos.setBounds(12, 5, 354, 14);
		panel.add(lblCadastroDeEventos);
		
		JPanel panel_Salvar = new JPanel();
		panel_Salvar.setBackground(Color.LIGHT_GRAY);
		panel_Salvar.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Salvar.setBounds(10, 40, 676, 130);
		contentPane.add(panel_Salvar);
		panel_Salvar.setLayout(null);
		JComboBox comboBox_Local = new JComboBox();
		JComboBox comboBox_Acesso = new JComboBox();
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		comboBox_Local.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G", "Todos"}));
		comboBox_Local.setBounds(55, 8, 116, 23);
		panel_Salvar.add(comboBox_Local);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(10, 12, 48, 14);
		panel_Salvar.add(lblLocal);
		
		JLabel lblAcesso = new JLabel("Acesso:");
		lblAcesso.setBounds(181, 12, 48, 14);
		panel_Salvar.add(lblAcesso);
		
		
		comboBox_Acesso.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Todas", "Diretoria", "Funcion\u00E1rios", "Convidados", "Outros"}));
		comboBox_Acesso.setBounds(237, 8, 116, 23);
		panel_Salvar.add(comboBox_Acesso);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dtm = (DefaultTableModel) table.getModel();
				while(dtm.getRowCount() != 0) {
					dtm.removeRow(0);
				}
				
				try {
					Connection conexao = new Conexao().fazer_conexao();
					ConexaoAreasEspeciais lista = new ConexaoAreasEspeciais(conexao);
					for(AreasEspeciais x: lista.pesquisarAreasEspeciais((String) comboBox_Local.getSelectedItem(), (String) comboBox_Acesso.getSelectedItem())) {
						if(x.getDataInicio() == null && x.getDataFim() == null) {
							Object[] dados = {x.getId(),x.getBloco(),x.getAcesso(),x.getDataInicio(),x.getDataFim(),x.getIndeterminado(),
									x.getTotalVagas(),x.getDescricao(),x.getStatus()};
							dtm.addRow(dados);
						}else {
							Object[] dados = {x.getId(),x.getBloco(),x.getAcesso(),sdf.format(x.getDataInicio()),sdf.format(x.getDataFim()),x.getIndeterminado(),
									x.getTotalVagas(),x.getDescricao(),x.getStatus()};
							dtm.addRow(dados);
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPesquisar.setBounds(368, 8, 105, 23);
		panel_Salvar.add(btnPesquisar);
		
		JPanel panel_Tabela = new JPanel();
		panel_Tabela.setBackground(Color.LIGHT_GRAY);
		panel_Tabela.setLayout(null);
		panel_Tabela.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Tabela.setBounds(10, 177, 676, 181);
		contentPane.add(panel_Tabela);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBounds(10, 11, 656, 159);
		panel_Tabela.add(scrollPane);

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Bloco", "Acesso", "Inicio", "Fim", "Indeterminado", "Total Vagas", "Descri\u00E7\u00E3o", "Status"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(41);
		table.getColumnModel().getColumn(1).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.getColumnModel().getColumn(3).setPreferredWidth(84);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(110);
		table.getColumnModel().getColumn(6).setPreferredWidth(93);
		table.getColumnModel().getColumn(7).setPreferredWidth(81);
		scrollPane.setViewportView(table);
		//função para arrastar a tela da forma que quiser
		JLabel lbl_Mover_Tela = new JLabel("");
		lbl_Mover_Tela.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				xx = e.getX();
				xy = e.getY();
			}
		});
		lbl_Mover_Tela.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				MonitoramentoAreasEspeciais.this.setLocation(x - xx, y - xy);
				
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;
				int row = table.getSelectedRow();
				if(table.getSelectedRow() != -1) {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					id = (int) dtm.getValueAt(row, 0);
					dtm.removeRow(table.getSelectedRow());
					
				}else {
					
				}
				if(id != 0) {
					try {
						Connection conexao = new Conexao().fazer_conexao();
						ConexaoAreasEspeciais removerAreaEspecial = new ConexaoAreasEspeciais(conexao);
						removerAreaEspecial.removerAreaEspecial(id);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado!");
				}
				
				
			}
		});
		btnRemover.setBounds(597, 363, 89, 23);
		contentPane.add(btnRemover);
		lbl_Mover_Tela.setBounds(0, 0, 605, 386);
		contentPane.add(lbl_Mover_Tela);
		

	}
}
