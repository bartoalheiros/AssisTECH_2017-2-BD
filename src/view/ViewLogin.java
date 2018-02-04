package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		setTitle("Assistech - Área de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{528, 0};
		gbl_contentPane.rowHeights = new int[]{56, 291, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(null);
		
		setResizable(false);
	    setLocationRelativeTo(null);
	    //pegarResolucao();    
	    
	    //Toolkit t = Toolkit.getDefaultToolkit();
		//Dimension dimensao = t.getScreenSize();
	    //panel.setSize((dimensao.width + 5), (dimensao.height - 38));
	    
	    setExtendedState(MAXIMIZED_BOTH);
	    
		textField = new JTextField();
		textField.setBounds(98, 98, 260, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(98, 73, 46, 14);
		panel.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(98, 151, 46, 14);
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 174, 260, 20);
		panel.add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(272, 244, 89, 23);
		panel.add(btnEntrar);
	}

	
	
	private void pegarResolucao() {
       Toolkit t = Toolkit.getDefaultToolkit();
	   Dimension dimensao = t.getScreenSize();
	   this.setSize((dimensao.width + 5), (dimensao.height - 38));
	 
	}
}
