package br.ufrpe.bds.assistech.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
import br.ufrpe.bds.assistech.model.bean.Computador;

@SuppressWarnings("serial")
public class GerenciamentoComputadorView extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cod_eq;
	private JTextField tf_sis_op;
	private JTextField tf_end_ip;
	private JTextField tf_fab_bi;
	private JTextField tf_ver_bi;
	private JTextField tf_tipo;


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
					GerenciamentoComputadorView frame = new GerenciamentoComputadorView(/*con*/);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTable table;
	private JTextField tfBuscar;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JButton btnVoltar;

	/**
	 * Create the frame.
	 */
	public GerenciamentoComputadorView() {

		initComponents();

	}
	private void initComponents() {

		setTitle("Cadastro Computador");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(313, 9, 86, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_0 = new JLabel("Codigo equipamento:");
		lblNewLabel_0.setBounds(8, 12, 109, 14);
		contentPane.add(lblNewLabel_0);

		JLabel lblNewLabel_1 = new JLabel("Sistema operacional:");
		lblNewLabel_1.setBounds(10, 43, 109, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Endereço Ip:");
		lblNewLabel_2.setBounds(11, 75, 86, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fabricante da bios:");
		lblNewLabel_3.setBounds(11, 102, 126, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Versão da bios:");
		lblNewLabel_4.setBounds(12, 138, 110, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tipo: ");
		lblNewLabel_5.setBounds(15, 171, 99, 14);
		contentPane.add(lblNewLabel_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 204, 553, 261);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_ComputadorMouseClicked(evt);
			}
		});
		table.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tbl_ComputadorKeyReleased(evt);
			}
		});

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Cod_equipamento", "Sistema_Operacional", "Endereco_Ip", "Fabricante_bios", "Versao_Bios", "Tipo"
				}
				) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, String.class, String.class, Object.class, Object.class, String.class, Object.class, Integer.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(142);
		table.getColumnModel().getColumn(2).setPreferredWidth(81);
		table.getColumnModel().getColumn(3).setResizable(true);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(126);
		
		
		table.getTableHeader().setReorderingAllowed(false);

		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.setIcon(new ImageIcon("img/search.png"));
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readJTableForCod(tfBuscar.getText());
			}
		}); 

		btn_buscar.setBounds(410, 36, 99, 30);
		contentPane.add(btn_buscar);

		tfBuscar = new JTextField();
		tfBuscar.setBounds(366, 9, 143, 20);
		contentPane.add(tfBuscar);
		tfBuscar.setColumns(6);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Computador o = preencherComputador();
				
				Fachada fch = Fachada.getInstance();

				fch.cadastrarComputador(o);
				readJTable();

			}
		});

		btnCadastrar.setBounds(251, 8, 105, 23);
		contentPane.add(btnCadastrar);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada fch = Fachada.getInstance();
				Computador o = preencherComputador();
				fch.atualizarComputador(o);
				
				readJTable();
			}
		});
		btnAtualizar.setBounds(251, 70, 82, 23);
		contentPane.add(btnAtualizar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				Computador o = preencherComputador();
				Fachada fch = Fachada.getInstance();
				
				fch.removerComputador(o);
				
				readJTable();
			}
		});		

		btnExcluir.setBounds(251, 39, 81, 23);
		contentPane.add(btnExcluir);

		JButton btnLimparDados = new JButton("Limpar Dados");
		btnLimparDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});

		btnLimparDados.setIcon(new ImageIcon("img\\refresh.png"));
		btnLimparDados.setBounds(251, 104, 103, 23);
		contentPane.add(btnLimparDados);

		tf_cod_eq = new JTextField();
		tf_cod_eq.setBounds(132, 9, 109, 20);
		contentPane.add(tf_cod_eq);
		tf_cod_eq.setColumns(10);

		tf_sis_op = new JTextField();
		tf_sis_op.setColumns(10);
		tf_sis_op.setBounds(133, 40, 109, 20);
		contentPane.add(tf_sis_op);

		tf_end_ip = new JTextField();
		tf_end_ip.setColumns(10);
		tf_end_ip.setBounds(133, 71, 109, 20);
		contentPane.add(tf_end_ip);

		tf_fab_bi = new JTextField();
		tf_fab_bi.setColumns(10);
		tf_fab_bi.setBounds(134, 103, 109, 20);
		contentPane.add(tf_fab_bi);

		tf_ver_bi = new JTextField();
		tf_ver_bi.setColumns(10);
		tf_ver_bi.setBounds(135, 136, 109, 20);
		contentPane.add(tf_ver_bi);

		tf_tipo = new JTextField();
		tf_tipo.setColumns(10);
		tf_tipo.setBounds(135, 169, 109, 20);
		contentPane.add(tf_tipo);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readJTable();
			}
		});
		btnVoltar.setBounds(251, 134, 91, 23);
		contentPane.add(btnVoltar);

		readJTable();

		setResizable(true);

	}


	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		Fachada fch = Fachada.getInstance();

		for (Computador pc : fch.listarTodosComputadores()) {

			modelo.addRow(new Object[]{
					pc.getCodEquipamento(),
					pc.getSistemaOperacional(),
					pc.getEnderecoIp(),
					pc.getFabricanteBios(),
					pc.getVersaoBios(),
					pc.getTipo(),

			});
		}
	}

	private void readJTableForCod(String str) {
		// TODO Auto-generated method stub

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		Fachada fch = Fachada.getInstance();

		for (Computador pc : fch.listarTodosComputadoresPorCod(str)) {
			modelo.addRow(new Object[]{
					pc.getCodEquipamento(),
					pc.getSistemaOperacional(),
					pc.getEnderecoIp(),
					pc.getFabricanteBios(),
					pc.getVersaoBios(),
					pc.getTipo(),

			});
		}
	}

	private void tbl_ComputadorMouseClicked(java.awt.event.MouseEvent evt){
		if (table.getSelectedRow() != -1) {

			tf_cod_eq.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			tf_sis_op.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			tf_end_ip.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			tf_fab_bi.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			tf_ver_bi.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			tf_tipo.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
		}

	}
	private void tbl_ComputadorKeyReleased(java.awt.event.KeyEvent evt) {
		if (table.getSelectedRow() != -1) {

			tf_cod_eq.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			tf_sis_op.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			tf_end_ip.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			tf_fab_bi.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			tf_ver_bi.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			tf_tipo.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
		}

	}
	
	//método para preencher o objeto computador, a partir dos campos informados pelo usuário
	private Computador preencherComputador() {
		Computador o = new Computador();
		o.setCodEquipamento(tf_cod_eq.getText());
		o.setSistemaOperacional(tf_sis_op.getText());
		o.setEnderecoIp(tf_end_ip.getText());
		o.setFabricanteBios(tf_fab_bi.getText());
		o.setVersaoBios(tf_ver_bi.getText());
		o.setTipo(tf_tipo.getText());
		
		return o;
	}
	
	//método para limpar os campos do formulário
	private void limparCampos() {
		tf_cod_eq.setText("");
		tf_sis_op.setText("");
		tf_end_ip.setText("");
		tf_fab_bi.setText("");
		tf_ver_bi.setText("");
		tf_tipo.setText("");
	}
}
