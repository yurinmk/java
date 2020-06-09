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
import modelo.Teste;

import javax.swing.border.SoftBevelBorder;

public class DarPermissao extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DefaultTableModel dtm = new DefaultTableModel();
	private JButton btnVoltarMenu;
	String local;
	int xx;
	int xy;
	private JButton btnRemover;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarPermissao frame = new DarPermissao();
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
	public DarPermissao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.POPUP);
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 720, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(208, 50, 47));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 724, 27);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_Sair = new JButton("");
		btn_Sair.setToolTipText("sair");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btn_Sair.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/fechar.png")));
		btn_Sair.setBounds(685, 5, 16, 16);
		panel.add(btn_Sair);
		
		JLabel lblCadastroDeEventos = new JLabel("Dar Permiss\u00E3o");
		lblCadastroDeEventos.setBounds(12, 5, 232, 14);
		panel.add(lblCadastroDeEventos);
		
		btnVoltarMenu = new JButton("");
		btnVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioRh passarTela = new FuncionarioRh();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltarMenu.setToolTipText("menu");
		btnVoltarMenu.setIcon(new ImageIcon(DarPermissao.class.getResource("/imagens/voltar.png")));
		btnVoltarMenu.setBounds(659, 5, 16, 16);
		panel.add(btnVoltarMenu);
		
		JPanel panel_Salvar = new JPanel();
		panel_Salvar.setBackground(Color.LIGHT_GRAY);
		panel_Salvar.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Salvar.setBounds(10, 40, 694, 130);
		contentPane.add(panel_Salvar);
		panel_Salvar.setLayout(null);
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 11, 193, 108);
		panel_Salvar.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(10, 11, 47, 14);
		panel_1.add(lblLocal);
		JComboBox comboBox_Local = new JComboBox();
		comboBox_Local.setBounds(67, 7, 116, 23);
		panel_1.add(comboBox_Local);
		comboBox_Local.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G", "Todos"}));
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(76, 74, 107, 23);
		panel_1.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm = (DefaultTableModel) table.getModel();
				while(dtm.getRowCount() != 0) {
					dtm.removeRow(0);
				}
				if(comboBox_Local.getSelectedItem().equals("Selecionar...")) {
					JOptionPane.showMessageDialog(null, "Nenhum local selecionado!");
				}else {					
					try {
						Connection conexao = new Conexao().fazer_conexao();
						ConexaoAreasEspeciais pesquisa = new ConexaoAreasEspeciais(conexao);
						for(AreasEspeciais x : pesquisa.pesquisarAreasEspeciais((String)comboBox_Local.getSelectedItem(), "Todas")) {
							if(x.getDataInicio() == null || x.getDataFim() == null) {
								Object[] dados = {x.getId(),x.getBloco(),x.getAcesso(),x.getDataInicio(),x.getDataFim(),x.getIndeterminado(),x.getTotalVagas(),x.getDescricao(),x.getStatus()};
								dtm.addRow(dados);
							}else {
								Object[] dados = {x.getId(),x.getBloco(),x.getAcesso(),sdf.format(x.getDataInicio()),sdf.format(x.getDataFim()),x.getIndeterminado(),x.getTotalVagas(),x.getDescricao(),x.getStatus()};
								dtm.addRow(dados);
							}
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		btnPesquisar.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(251, 11, 193, 107);
		panel_Salvar.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAcesso = new JLabel("Acesso:");
		lblAcesso.setBounds(10, 11, 54, 14);
		panel_2.add(lblAcesso);
		JComboBox comboBox_Acesso = new JComboBox();
		comboBox_Acesso.setBounds(67, 7, 116, 23);
		panel_2.add(comboBox_Acesso);
		
		
		comboBox_Acesso.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Diretoria", "Funcion\u00E1rios", "Convidados", "Outros"}));
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int x = table.getSelectedRow();
					int id = (int) table.getValueAt(x, 0);
					String valor = (String) table.getValueAt(x, 2) + "/"+(String)comboBox_Acesso.getSelectedItem();
					if(comboBox_Acesso.getSelectedItem().equals("Selecionar...")) {
						JOptionPane.showMessageDialog(null, "Valor não encontrado!");
					}else {
						table.setValueAt(valor, x, 2);
					}
				}catch(ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "Nenhum item da tabela selecionado!");
				}
				
				
				
				
			}
		});
		btnAdicionar.setBackground(Color.LIGHT_GRAY);
		btnAdicionar.setBounds(94, 73, 89, 23);
		panel_2.add(btnAdicionar);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1.setBounds(491, 11, 193, 107);
		panel_Salvar.add(panel_2_1);
		
		JLabel lblAcesso_1 = new JLabel("Acesso:");
		lblAcesso_1.setBounds(10, 11, 54, 14);
		panel_2_1.add(lblAcesso_1);
		
		JComboBox comboBox_Acesso_R = new JComboBox();
		comboBox_Acesso_R.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Diretoria", "Funcion\u00E1rios", "Convidados", "Outros"}));
		comboBox_Acesso_R.setBounds(67, 7, 116, 23);
		panel_2_1.add(comboBox_Acesso_R);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int x = table.getSelectedRow();
					int id = (int) table.getValueAt(x, 0);
					String valor = ((String) table.getValueAt(x, 2));
					int posicaoParaRemover = valor.indexOf((String)comboBox_Acesso_R.getSelectedItem())-1;
					if(posicaoParaRemover == -2) {
						JOptionPane.showMessageDialog(null, "Valor não encontrado!");
					}else {
						table.setValueAt(valor.substring(0, posicaoParaRemover), x, 2);
					}
				}catch(ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "Nenhum item da tabela selecionado!");
				}
			
				
				
				
			}
		});
		btnRemover.setBackground(Color.LIGHT_GRAY);
		btnRemover.setBounds(94, 73, 89, 23);
		panel_2_1.add(btnRemover);
		
		JPanel panel_Tabela = new JPanel();
		panel_Tabela.setBackground(Color.LIGHT_GRAY);
		panel_Tabela.setLayout(null);
		panel_Tabela.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Tabela.setBounds(10, 177, 694, 181);
		contentPane.add(panel_Tabela);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBounds(10, 11, 674, 159);
		panel_Tabela.add(scrollPane);

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Bloco", "Acesso", "Inicio", "Fim", "Indeterminado", "Total Vagas", "Descri\u00E7\u00E3o", "Status"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(82);
		table.getColumnModel().getColumn(2).setPreferredWidth(83);
		table.getColumnModel().getColumn(5).setPreferredWidth(87);
		table.getColumnModel().getColumn(6).setPreferredWidth(70);
		table.getColumnModel().getColumn(7).setPreferredWidth(62);
		table.getColumnModel().getColumn(8).setPreferredWidth(70);
		scrollPane.setViewportView(table);
		
		JButton btn_SalvarNoBanco = new JButton("Salvar");
		btn_SalvarNoBanco.setBackground(Color.LIGHT_GRAY);
		//salvar eventos no banco de dados
		btn_SalvarNoBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = table.getSelectedRow();
				int id = (int) table.getValueAt(x, 0);
				String acesso = (String) table.getValueAt(x, 2);
				try {
					Connection conexao = new Conexao().fazer_conexao();
					ConexaoAreasEspeciais darPermissao = new ConexaoAreasEspeciais(conexao);
					darPermissao.darPermissao(id, acesso);
					JOptionPane.showMessageDialog(null, "Permissão dada com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while(dtm.getRowCount() !=0) {
					dtm.removeRow(0);
				}
				
			}
		});
		btn_SalvarNoBanco.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/database_add.png")));
		btn_SalvarNoBanco.setBounds(605, 363, 99, 23);
		contentPane.add(btn_SalvarNoBanco);
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
				DarPermissao.this.setLocation(x - xx, y - xy);
				
			}
		});
		lbl_Mover_Tela.setBounds(0, 0, 724, 386);
		contentPane.add(lbl_Mover_Tela);

	}
	public void cargo(boolean valor) {
		btnVoltarMenu.setVisible(valor);	
		
	}
}
