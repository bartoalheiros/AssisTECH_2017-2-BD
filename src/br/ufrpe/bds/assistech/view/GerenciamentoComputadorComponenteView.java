package br.ufrpe.bds.assistech.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

import br.ufrpe.bds.assistech.model.bean.Chamado;
import br.ufrpe.bds.assistech.model.bean.Componente;
import br.ufrpe.bds.assistech.model.bean.Computador;

@SuppressWarnings("serial")
public class GerenciamentoComputadorComponenteView extends JFrame {

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
					GerenciamentoComputadorComponenteView frame = new GerenciamentoComputadorComponenteView(/*con*/);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTable tableComputador;
	private JTextField tfBuscar;
	private JButton btnCadastrarComputador;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JButton btnVoltar;
	private JScrollPane scrollPane_1;
	private JTextField tfCodigoComponente;
	private JTextField tfTipoComponente;
	private JTextField tfModeloComponente;
	private JTextField tfFabricanteComponente;
	private JTextField tfNumSerieComponente;
	private JTextField tfOnboardComponente;
	private JTextField txtBuscarComponente;
	private JTable tableComponente;

	/**
	 * Create the frame.
	 */
	public GerenciamentoComputadorComponenteView() {

		initComponents();

	}
	private void initComponents() {

		setTitle("Cadastro Computador");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 788);
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
		scrollPane.setBounds(8, 204, 650, 212);
		contentPane.add(scrollPane);

		tableComputador = new JTable();
		scrollPane.setViewportView(tableComputador);
		tableComputador.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_ComputadorMouseClicked(evt);
			}
		});
		tableComputador.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tbl_ComputadorKeyReleased(evt);
			}
		});

		tableComputador.setModel(new DefaultTableModel(
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
		tableComputador.getColumnModel().getColumn(0).setPreferredWidth(85);
		tableComputador.getColumnModel().getColumn(1).setPreferredWidth(142);
		tableComputador.getColumnModel().getColumn(2).setPreferredWidth(81);
		tableComputador.getColumnModel().getColumn(3).setResizable(true);
		tableComputador.getColumnModel().getColumn(4).setPreferredWidth(110);
		tableComputador.getColumnModel().getColumn(5).setPreferredWidth(126);


		tableComputador.getTableHeader().setReorderingAllowed(false);

		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.setIcon(new ImageIcon("img/search.png"));
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readJTableForCod(tfBuscar.getText());
			}
		}); 

		btn_buscar.setBounds(562, 164, 99, 30);
		contentPane.add(btn_buscar);

		tfBuscar = new JTextField();
		tfBuscar.setBounds(409, 168, 143, 20);
		contentPane.add(tfBuscar);
		tfBuscar.setColumns(6);

		btnCadastrarComputador = new JButton("Cadastrar");
		btnCadastrarComputador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Computador o = preencherComputador();

				Fachada fch = Fachada.getInstance();

				fch.cadastrarComputador(o);
				readJTable();

			}
		});

		btnCadastrarComputador.setBounds(251, 8, 105, 23);
		contentPane.add(btnCadastrarComputador);

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

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 459, 650, 173);
		contentPane.add(scrollPane_1);

		tableComponente = new JTable();
		tableComponente.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Codigo", "Tipo", "Modelo", "Fabricante", "Numero de Serie", "Onboard"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		tableComponente.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_ComponenteMouseClicked(evt);
			}
		});
		tableComponente.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tbl_ComponenteKeyReleased(evt);
			}
		});
		scrollPane_1.setViewportView(tableComponente);

		tfCodigoComponente = new JTextField();
		tfCodigoComponente.setBounds(8, 668, 86, 20);
		contentPane.add(tfCodigoComponente);
		tfCodigoComponente.setColumns(10);

		tfTipoComponente = new JTextField();
		tfTipoComponente.setBounds(104, 668, 86, 20);
		contentPane.add(tfTipoComponente);
		tfTipoComponente.setColumns(10);

		tfModeloComponente = new JTextField();
		tfModeloComponente.setBounds(200, 668, 86, 20);
		contentPane.add(tfModeloComponente);
		tfModeloComponente.setColumns(10);

		tfFabricanteComponente = new JTextField();
		tfFabricanteComponente.setBounds(296, 668, 86, 20);
		contentPane.add(tfFabricanteComponente);
		tfFabricanteComponente.setColumns(10);

		tfNumSerieComponente = new JTextField();
		tfNumSerieComponente.setBounds(395, 668, 86, 20);
		contentPane.add(tfNumSerieComponente);
		tfNumSerieComponente.setColumns(10);

		tfOnboardComponente = new JTextField();
		tfOnboardComponente.setBounds(492, 668, 86, 20);
		contentPane.add(tfOnboardComponente);
		tfOnboardComponente.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo: *");
		lblCodigo.setBounds(10, 643, 46, 14);
		contentPane.add(lblCodigo);

		JLabel lblTipo = new JLabel("Tipo: *");
		lblTipo.setBounds(104, 643, 46, 14);
		contentPane.add(lblTipo);

		JLabel lblModelo = new JLabel("Modelo: *");
		lblModelo.setBounds(200, 643, 60, 14);
		contentPane.add(lblModelo);

		JLabel lblFabricante = new JLabel("Fabricante: *");
		lblFabricante.setBounds(296, 643, 68, 14);
		contentPane.add(lblFabricante);

		JLabel lblNmeroSrie = new JLabel("Número Série: *");
		lblNmeroSrie.setBounds(395, 643, 86, 14);
		contentPane.add(lblNmeroSrie);

		JLabel lblOnbard = new JLabel("Onbard:");
		lblOnbard.setBounds(492, 643, 46, 14);
		contentPane.add(lblOnbard);

		JButton btnCadastrarComponente = new JButton("Cadastrar");
		btnCadastrarComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Componente co = preencherComponente();
				Fachada fch = Fachada.getInstance();		
				fch.cadastrarComponente(co);		
				try {		
					readJTableComponente();		
				} catch (Exception e) {		
					// TODO Auto-generated catch block		
					e.printStackTrace();		
				}		
			}

		});
		btnCadastrarComponente.setBounds(6, 699, 91, 23);
		contentPane.add(btnCadastrarComponente);

		JButton btnRemoverComponente = new JButton("Remover");
		btnRemoverComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fch = Fachada.getInstance();		
				Componente o = preencherComponente();

				fch.removerComponente(o);
				
				readJTableComponente();


			}
		});
		btnRemoverComponente.setBounds(200, 699, 91, 23);
		contentPane.add(btnRemoverComponente);

		JButton btnAtualizarComponente = new JButton("Atualizar");
		btnAtualizarComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Fachada fch = Fachada.getInstance();		
				Componente o = preencherComponente();

				fch.atualizarComponente(o);		

				try {		
					readJTableComponente();		
				} catch (Exception e) {		
					// TODO Auto-generated catch block		
					e.printStackTrace();		
				}		
			}
		});
		btnAtualizarComponente.setBounds(104, 699, 91, 23);
		contentPane.add(btnAtualizarComponente);

		JButton btnBuscarComponente = new JButton("Buscar");
		btnBuscarComponente.setBounds(552, 716, 91, 23);
		contentPane.add(btnBuscarComponente);

		txtBuscarComponente = new JTextField();
		txtBuscarComponente.setText("");
		txtBuscarComponente.setBounds(366, 717, 166, 20);
		contentPane.add(txtBuscarComponente);
		txtBuscarComponente.setColumns(10);

		JLabel lblComponentes = new JLabel("Componentes:");
		lblComponentes.setBounds(8, 434, 86, 14);
		contentPane.add(lblComponentes);

		readJTable();

		setResizable(true);

	}


	private void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) tableComputador.getModel();
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

		DefaultTableModel modelo = (DefaultTableModel) tableComputador.getModel();
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
		if (tableComputador.getSelectedRow() != -1) {

			tf_cod_eq.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 0).toString());
			tf_sis_op.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 1).toString());
			tf_end_ip.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 2).toString());
			tf_fab_bi.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 3).toString());
			tf_ver_bi.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 4).toString());
			tf_tipo.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 5).toString());

			readJTableComponenteForCodComputador(); 
		}

	}
	private void tbl_ComputadorKeyReleased(java.awt.event.KeyEvent evt) {
		if (tableComputador.getSelectedRow() != -1) {

			tf_cod_eq.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 0).toString());
			tf_sis_op.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 1).toString());
			tf_end_ip.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 2).toString());
			tf_fab_bi.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 3).toString());
			tf_ver_bi.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 4).toString());
			tf_tipo.setText(tableComputador.getValueAt(tableComputador.getSelectedRow(), 5).toString());

			readJTableComponenteForCodComputador(); 
		}

	}

	private void tbl_ComponenteMouseClicked(java.awt.event.MouseEvent evt){
		if (tableComponente.getSelectedRow() != -1) {

			tfCodigoComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 0).toString());
			tfTipoComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 1).toString());
			tfModeloComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 2).toString());
			tfFabricanteComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 3).toString());
			tfNumSerieComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 4).toString());
			tfOnboardComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedColumnCount(), 5).toString());


		}

	}
	private void tbl_ComponenteKeyReleased(java.awt.event.KeyEvent evt) {
		if (tableComponente.getSelectedRow() != -1) {

			tfCodigoComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 0).toString());
			tfTipoComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 1).toString());
			tfModeloComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 2).toString());
			tfFabricanteComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 3).toString());
			tfNumSerieComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedRow(), 4).toString());
			tfOnboardComponente.setText(tableComponente.getValueAt(tableComponente.getSelectedColumnCount(), 5).toString());

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

	private void readJTableComponente() {
		Fachada fch = Fachada.getInstance();
		List<Componente> componentes = new ArrayList<>();

		componentes = fch.listarTodosComponentes();

		DefaultTableModel modelo = (DefaultTableModel) tableComponente.getModel();
		modelo.setNumRows(0);

		for (Componente o : componentes) {
			modelo.addRow(new Object[]{
					o.getCod(),
					o.getTipo(),
					o.getModelo(),
					o.getFabricante(),
					o.getNumeroSerie(),
					o.getOnboard()
			});
		}
	}

	//carrega a tabela de Componente a partir dos dados selecionados na linha da tabela de Computador
	private void readJTableComponenteForCodComputador() {
		Fachada fch = Fachada.getInstance();
		List<Componente> componentes = new ArrayList<>();

		componentes = fch.listarComponentePorCodComputador(tableComputador.getValueAt(tableComputador.getSelectedRow(), 0).toString());

		DefaultTableModel modelo = (DefaultTableModel) tableComponente.getModel();
		modelo.setNumRows(0);

		for (Componente o : componentes) {
			modelo.addRow(new Object[]{
					o.getCod(),
					o.getTipo(),
					o.getModelo(),
					o.getFabricante(),
					o.getNumeroSerie(),
					o.getOnboard()
			});
		}
	}

	private Componente preencherComponente() {
		Componente o = new Componente();		
		o.setCod(Long.parseLong(tfCodigoComponente.getText()));		
		o.setTipo(tfTipoComponente.getText());		
		o.setModelo(tfModeloComponente.getText());		
		o.setFabricante(tfFabricanteComponente.getText());		
		o.setNumeroSerie(tfNumSerieComponente.getText());		
		o.setOnboard(tfOnboardComponente.getText());

		return o;
	}
}
