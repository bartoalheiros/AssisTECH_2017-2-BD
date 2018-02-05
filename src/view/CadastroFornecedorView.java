package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class CadastroFornecedorView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCnpj;
	private JTextField txtRazaoSocial;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtConsulta;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFornecedorView frame = new CadastroFornecedorView();
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
	public CadastroFornecedorView() {
		setTitle("Cadastro de fornecedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CNPJ:");
		lblNewLabel.setBounds(9, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCnpj = new JTextField();
		txtCnpj.setBounds(97, 8, 116, 20);
		contentPane.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(9, 158, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblRazoSocial = new JLabel("Razão social:");
		lblRazoSocial.setBounds(10, 45, 77, 14);
		contentPane.add(lblRazoSocial);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 73, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelafone = new JLabel("Telefone:");
		lblTelafone.setBounds(10, 110, 54, 14);
		contentPane.add(lblTelafone);
		
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(97, 39, 116, 20);
		contentPane.add(txtRazaoSocial);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(97, 70, 116, 20);
		contentPane.add(txtEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(97, 101, 116, 20);
		contentPane.add(txtTelefone);
		
		txtConsulta = new JTextField();
		txtConsulta.setColumns(10);
		txtConsulta.setBounds(112, 159, 133, 20);
		contentPane.add(txtConsulta);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBounds(223, 100, 93, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(386, 100, 83, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(313, 100, 77, 23);
		contentPane.add(btnExcluir);
		
		JButton btnSalvarAlteraes = new JButton("Salvar Alterações");
		btnSalvarAlteraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvarAlteraes.setBounds(313, 134, 136, 23);
		contentPane.add(btnSalvarAlteraes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 192, 478, 127);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CNPJ", "Raz\u00E3o social", "Email", "Telefone"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 15, 294, 163);
		contentPane.add(panel);
		
	}
}
