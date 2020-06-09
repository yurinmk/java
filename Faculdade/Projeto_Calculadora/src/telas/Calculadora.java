package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Resultado;
	int temp1;
	Double temp2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setLocationRelativeTo(null);
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
	public Calculadora() {

		setForeground(Color.BLACK);
		setTitle("Calculator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Resultado = new JPanel();
		panel_Resultado.setBackground(Color.DARK_GRAY);
		panel_Resultado.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		panel_Resultado.setBounds(0, 0, 440, 32);
		contentPane.add(panel_Resultado);
		panel_Resultado.setLayout(null);
		
		tf_Resultado = new JTextField();
		tf_Resultado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		tf_Resultado.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_Resultado.setBounds(5, 5, 428, 21);
		panel_Resultado.add(tf_Resultado);
		tf_Resultado.setColumns(10);
		
		JPanel panel_Numeros = new JPanel();
		panel_Numeros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		panel_Numeros.setBackground(Color.DARK_GRAY);
		panel_Numeros.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, new Color(0, 0, 0), null, null));
		panel_Numeros.setBounds(0, 31, 440, 223);
		contentPane.add(panel_Numeros);
		panel_Numeros.setLayout(null);
		
		JButton btn_7 = new JButton("7");
		btn_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + "7";
				tf_Resultado.setText(temp);
			}
		});
		btn_7.setBounds(4, 5, 107, 52);
		panel_Numeros.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + 8;
				tf_Resultado.setText(temp);
			}
		});
		btn_8.setBounds(112, 5, 107, 52);
		panel_Numeros.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + "9";
				tf_Resultado.setText(temp);
			}
		});
		btn_9.setBounds(220, 5, 107, 52);
		panel_Numeros.add(btn_9);
		
		JButton btn_Divisao = new JButton("/");
		btn_Divisao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_Divisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp1 == 0) {
					temp1 = 4;
					temp2 = Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 1) {
					temp2 += Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 2) {
					temp2 -= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 3) {
					temp2 *= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 4) {
					temp2 /= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}
				temp1 = 4;
				
			}
		});
		btn_Divisao.setBounds(328, 5, 107, 52);
		panel_Numeros.add(btn_Divisao);
		
		JButton btn_4 = new JButton("4");
		btn_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + "4";
				tf_Resultado.setText(temp);
			}
		});
		btn_4.setBounds(4, 58, 107, 52);
		panel_Numeros.add(btn_4);
		
		JButton btn_1 = new JButton("1");
		btn_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + "1";
				tf_Resultado.setText(temp);
			}
		});
		btn_1.setBounds(4, 111, 107, 52);
		panel_Numeros.add(btn_1);
		
		JButton btn_0 = new JButton("0");
		btn_0.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + "0";
				tf_Resultado.setText(temp);
			}
		});
		btn_0.setBounds(4, 164, 107, 52);
		panel_Numeros.add(btn_0);
		
		JButton btn_5 = new JButton("5");
		btn_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + "5";
				tf_Resultado.setText(temp);
			}
		});
		btn_5.setBounds(112, 58, 107, 52);
		panel_Numeros.add(btn_5);
		
		JButton btn_2 = new JButton("2");
		btn_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + "2";
				tf_Resultado.setText(temp);
			}
		});
		btn_2.setBounds(112, 111, 107, 52);
		panel_Numeros.add(btn_2);
		
		JButton btn_Ponto = new JButton(".");
		btn_Ponto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_Ponto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + ".";
				tf_Resultado.setText(temp);
			}
		});
		btn_Ponto.setBounds(112, 164, 107, 52);
		panel_Numeros.add(btn_Ponto);
		
		JButton btn_6 = new JButton("6");
		btn_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + "6";
				tf_Resultado.setText(temp);
			}
		});
		btn_6.setBounds(220, 58, 107, 52);
		panel_Numeros.add(btn_6);
		
		JButton btn_3 = new JButton("3");
		btn_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) 
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
		});
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf_Resultado.getText() + "3";
				tf_Resultado.setText(temp);
			}
		});
		btn_3.setBounds(220, 111, 107, 52);
		panel_Numeros.add(btn_3);
		JButton btn_Igual = new JButton("=");
		btn_Igual.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_Igual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp1 == 1) {
					temp2 += Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 2) {
					temp2 -= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 3) {
					temp2 *= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 4) {
					temp2 /= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}	
				tf_Resultado.setText(Double.toString(temp2));
				temp2 = 0.0;
				
				
			}
		});
		btn_Igual.setBounds(220, 164, 107, 52);
		panel_Numeros.add(btn_Igual);
		
		JButton btn_Vezes = new JButton("*");
		btn_Vezes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_Vezes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp1 == 0) {
					temp1 = 3;
					temp2 = Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 1) {
					temp2 += Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 2) {
					temp2 -= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 3) {
					temp2 *= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 4) {
					temp2 /= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}
				temp1 = 3;
			
			}
		});
		btn_Vezes.setBounds(328, 58, 107, 52);
		panel_Numeros.add(btn_Vezes);
		
		JButton btn_Menos = new JButton("-");
		btn_Menos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_Menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp1 == 0) {
					temp1 = 2;
					temp2 = Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 1) {
					temp2 += Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 2) {
					temp2 -= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 3) {
					temp2 *= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 4) {
					temp2 /= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}
				temp1 = 2;
			}
		});
		btn_Menos.setBounds(328, 111, 107, 52);
		panel_Numeros.add(btn_Menos);
		
		JButton btn_Mais = new JButton("+");
		btn_Mais.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					temp1 = 0;
					temp2 = 0.0;
					tf_Resultado.setText("");
				}
			}
		});
		btn_Mais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp1 == 0) {
					temp1 = 1;
					temp2 = Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 1) {
					temp2 += Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 2) {
					temp2 -= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 3) {
					temp2 *= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}else if (temp1 == 4) {
					temp2 /= Double.parseDouble(tf_Resultado.getText());
					tf_Resultado.setText("");
				}
				temp1 = 1;
			}
		});
		btn_Mais.setBounds(328, 164, 107, 52);
		panel_Numeros.add(btn_Mais);
	}
}
