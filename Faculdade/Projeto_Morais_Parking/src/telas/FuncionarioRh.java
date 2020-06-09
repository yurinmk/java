package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class FuncionarioRh extends JFrame {

	private JPanel contentPane;
	int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioRh frame = new FuncionarioRh();
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
	public FuncionarioRh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(208, 50, 47));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroUsuario passarTela = new CadastroUsuario();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setToolTipText("Cadastrar Funcion\u00E1rio");
		btnNewButton.setIcon(new ImageIcon(FuncionarioRh.class.getResource("/imagens/cadastrar_funcionario.png")));
		btnNewButton.setBounds(97, 177, 60, 73);
		btnNewButton.setBackground(new Color(208, 50, 47));
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarPermissao passarTela = new DarPermissao();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setToolTipText("Dar permiss\u00E3o em \u00E1reas especiais");
		btnNewButton_1.setIcon(new ImageIcon(FuncionarioRh.class.getResource("/imagens/dar_permiss\u00E3o.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(208, 50, 47));
		btnNewButton_1.setBounds(197, 177, 60, 73);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FuncionarioRh.class.getResource("/imagens/uniespP.jpg")));
		label.setBounds(171, 39, 110, 90);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 459, 23);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFuncionrioDoRh = new JLabel("Menu Funcion\u00E1rio do RH");
		lblFuncionrioDoRh.setBounds(10, 3, 179, 14);
		panel.add(lblFuncionrioDoRh);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("sair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(FuncionarioRh.class.getResource("/imagens/fechar.png")));
		btnNewButton_2.setBounds(422, 3, 16, 16);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acesso passarTela = new Acesso();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(FuncionarioRh.class.getResource("/imagens/deslogar.png")));
		btnNewButton_1_1.setToolTipText("Deslogar");
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(208, 50, 47));
		btnNewButton_1_1.setBounds(278, 177, 71, 73);
		contentPane.add(btnNewButton_1_1);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 444, 275);
		contentPane.add(lblNewLabel);
		

		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				xx = e.getX();
				xy = e.getY();

			}
		});
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				FuncionarioRh.this.setLocation(x - xx, y - xy);
			}
		});
	
		
		
	}
}
