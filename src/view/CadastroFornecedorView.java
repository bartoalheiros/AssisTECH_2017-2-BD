package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import model.bean.Fornecedor;
import model.bean.Funcionario;
import model.dao.FornecedorDAO;
import model.dao.FuncionarioDAO;

public class CadastroFornecedorView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCnpj;
	private JTextField txtRazaoSocial;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtConsulta;
	//private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
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
	
	private JTable table;
	private JTextField textField;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnExcluir;

	/**
	 * Create the frame.
	 */
	public CadastroFornecedorView() {
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Cadastro de fornecedor");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				Fornecedor f = new Fornecedor();
				f.setCnpj(Long.parseLong(txtCnpj.getText()));
				f.setRazaoSocial(txtRazaoSocial.getText());
				f.setEmail(txtEmail.getText());
				f.setTelefone(txtTelefone.getText());
				
				FornecedorDAO fdao = new FornecedorDAO();
				try {
					fdao.create(f);
				} catch (MySQLIntegrityConstraintViolationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
	    table.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyReleased(java.awt.event.KeyEvent evt) {
	            	tbl_FornecedorKeyReleased(evt);
	        }
	    });
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	 tbl_FornecedorMouseClicked(evt);
            }
        });
		
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
		
		readJTable();
		setResizable(false);

	}
	
	

	 private void tbl_FornecedorMouseClicked(java.awt.event.MouseEvent evt){
		 if (table.getSelectedRow() != -1) {

	            txtCnpj.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	            txtRazaoSocial.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	            txtEmail.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	            txtTelefone.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
		 }
		 
	 }
	 
	 private void tbl_FornecedorKeyReleased(java.awt.event.KeyEvent evt) {
		 if (table.getSelectedRow() != -1) {
			 
			 txtCnpj.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	            txtRazaoSocial.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	            txtEmail.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	            txtTelefone.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
		 }
		 
	 }	 

	 
	 public void readJTable(/*Connection con*/) {

			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			FornecedorDAO fdao = new FornecedorDAO();

			for (Fornecedor f : fdao.read()) {

				modelo.addRow(new Object[]{
						f.getCnpj(),
						f.getRazaoSocial(),
						f.getEmail(),
						f.getTelefone(),
						
				});
			}
		}

}
