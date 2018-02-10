package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.dao.FuncionarioDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Insets;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Login;
	private JPasswordField pf_password;

	

	/**
	 * Create the frame.
	 */
	public LoginView() {
		initComponents();
		
	}

	private void initComponents() {
		setTitle("Assistech - Área de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 61, 528, 291);
		contentPane.add(panel);
		panel.setLayout(null);
		
		setResizable(false);
	    setLocationRelativeTo(null);
	    //pegarResolucao();    
	    
	    //Toolkit t = Toolkit.getDefaultToolkit();
		//Dimension dimensao = t.getScreenSize();
	    //panel.setSize((dimensao.width + 5), (dimensao.height - 38));
	    
	    setExtendedState(MAXIMIZED_BOTH);
	    
		tf_Login = new JTextField();
		tf_Login.setBounds(98, 98, 260, 20);
		panel.add(tf_Login);
		tf_Login.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(98, 73, 46, 14);
		panel.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(98, 151, 46, 14);
		panel.add(lblSenha);
		
		pf_password = new JPasswordField();
		pf_password.setBounds(98, 174, 260, 20);
		panel.add(pf_password);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FuncionarioDAO dao = new FuncionarioDAO();
			       
			       if(dao.checkLogin(tf_Login.getText(), pf_password.getText())){
			    	   new MenuView().setVisible(true);
			    	   close();
			       }else{
			           JOptionPane.showMessageDialog(null, "Login ou Senha incorretos!");
			       }
			}
		});
		btnEntrar.setBounds(272, 244, 89, 23);
		panel.add(btnEntrar);
		
		JLabel lblAssistechBem = new JLabel("AssisTECH - Bem Vindo!");
		lblAssistechBem.setBounds(191, 11, 120, 14);
		contentPane.add(lblAssistechBem);

	}
	
	public void close() {
		this.setVisible(false);
	}
}
