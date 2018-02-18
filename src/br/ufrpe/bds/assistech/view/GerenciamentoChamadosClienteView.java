package br.ufrpe.bds.assistech.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import br.ufrpe.bds.assistech.model.bean.Chamado;
import br.ufrpe.bds.assistech.model.bean.Cliente;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GerenciamentoChamadosClienteView extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtPrioridade;
	private JTextField txtEndereco;
	private JTextField txtEstado;
	private JTextField txtEmail;
	private JTextField txtFone;
	private JTable table_1;
	private JTable table_2;
	private JTextField txtConsulta;
	private JTextField txtDigiteOCdigo;
	private JTextField tf_seq;
	private JTextField tf_tip;
	private JTextField tf_status_ch;
	private JTextArea textAreaDesc; 
	private JLabel lblSequencial;
	private JLabel lblTipo;
	private JLabel lblStatus;
	private JLabel lblPrioridade_1;
	private JTextField tf_prio;
	private JTextField tf_mat_sup;
	private JTextField tf_mat_tec_int;
	private JTextField tf_mat_aten;
	private JTextField tf_num_ord_serv;
	private JTextField tf_cod_cli;
	private JTextField tf_id_aten;
	private JTextField tf_dat_aber;

	/**
	 * Create the frame.
	 */
	public GerenciamentoChamadosClienteView() {
		initComponents();
	}

	public void initComponents() {
		setTitle("Cadastro de cliente");
		setBounds(100, 100, 771, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cod:");
		lblNewLabel.setBounds(9, 11, 46, 14);
		contentPane.add(lblNewLabel);

		txtCod = new JTextField();
		txtCod.setBounds(46, 8, 167, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);

		txtPrioridade = new JTextField();
		txtPrioridade.setColumns(10);
		txtPrioridade.setBounds(347, 8, 133, 20);
		contentPane.add(txtPrioridade);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readJTableForCod(txtConsulta.getText());
				preencherFormulario();
			}
		});
		btnConsultar.setBounds(640, 107, 93, 23);
		contentPane.add(btnConsultar);

		JLabel lblPrioridade = new JLabel("Prioridade:");
		lblPrioridade.setBounds(273, 11, 77, 14);
		contentPane.add(lblPrioridade);

		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(9, 44, 65, 14);
		contentPane.add(lblEndereco);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(9, 77, 54, 14);
		contentPane.add(lblEmail);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(309, 44, 54, 14);
		contentPane.add(lblEstado);

		JLabel lblFone = new JLabel("Fone:");
		lblFone.setBounds(255, 77, 54, 14);
		contentPane.add(lblFone);


		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(84, 41, 167, 20);
		contentPane.add(txtEndereco);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(373, 41, 167, 20);
		contentPane.add(txtEstado);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(73, 74, 116, 20);
		contentPane.add(txtEmail);

		txtFone = new JTextField();
		txtFone.setColumns(10);
		txtFone.setBounds(304, 74, 116, 20);
		contentPane.add(txtFone);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cl = new Cliente();
				cl.setCod(Long.parseLong(txtCod.getText()));
				cl.setPrioridade(txtPrioridade.getText());
				cl.setEndereco(txtEndereco.getText());
				cl.setEstado(txtEstado.getText());
				cl.setEmail(txtEmail.getText());
				cl.setFone(txtFone.getText());

				Fachada fc = Fachada.getInstance();
				//fc.removerCliente(cl);

				try {
					readJTable();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
				JButton btnCadastrar = new JButton("Cadastrar");
				btnCadastrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Cliente cl = new Cliente();
						cl.setCod(Long.parseLong(txtCod.getText()));
						cl.setPrioridade(txtPrioridade.getText());
						cl.setEndereco(txtEndereco.getText());
						cl.setEstado(txtEstado.getText());
						cl.setEmail(txtEmail.getText());
						cl.setFone(txtFone.getText());
						Fachada fc = Fachada.getInstance();
						fc.cadastrarCliente(cl);
						try {
							readJTable();
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				btnCadastrar.setBounds(9, 107, 93, 23);
				contentPane.add(btnCadastrar);
		btnExcluir.setBounds(112, 107, 77, 23);
		contentPane.add(btnExcluir);

		JButton btnSalvarAlteraes = new JButton("Salvar");
		btnSalvarAlteraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fch = Fachada.getInstance();
				Cliente cl = new Cliente();
				cl.setCod(Long.parseLong(txtCod.getText()));
				cl.setPrioridade(txtPrioridade.getText());
				cl.setEndereco(txtEndereco.getText());
				cl.setEstado(txtEstado.getText());
				cl.setEmail(txtEmail.getText());
				cl.setFone(txtFone.getText());

				//fch.atualizarCliente(cl);
			}
		});
		btnSalvarAlteraes.setBounds(199, 107, 65, 23);
		contentPane.add(btnSalvarAlteraes);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(9, 159, 724, 138);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();

		table_1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tbl_ClienteKeyReleased(evt);
			}
		});

		table_1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_ClienteMouseClicked(evt);
			}
		});

		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Cod", "Prioridade", "Endereco", "Estado", "Email", "Fone"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_1);

		JButton btnLimparCampos = new JButton("Limpar");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCod.setText("");
				txtPrioridade.setText("");
				txtEndereco.setText("");
				txtEstado.setText("");
				txtEmail.setText("");
				txtFone.setText("");
			}
		});
		btnLimparCampos.setBounds(273, 107, 71, 23);
		contentPane.add(btnLimparCampos);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					readJTable();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnVoltar.setBounds(642, 7, 91, 23);
		contentPane.add(btnVoltar);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(9, 326, 724, 138);
		contentPane.add(scrollPane_2);

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_ChamadoMouseClicked(evt);
			}
		});
		table_2.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tbl_ChamadoKeyReleased(evt);
			}
		});
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Sequencial", "Tipo", "Status_chamado", "Descricao", "Prioridade", "Mat_supervisor", "Mat_tecnico_interno", "Mat_atendente", "Num_ordem_servico", "Cod_cliente", "Id_atendimento", "Dta_abertura"
				}
				) {

			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		JLabel lblNewLabel_1 = new JLabel("CLIENTE:");
		lblNewLabel_1.setBounds(9, 143, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblChamado = new JLabel("CHAMADO:");
		lblChamado.setBounds(11, 308, 77, 14);
		contentPane.add(lblChamado);
		
		txtDigiteOCdigo = new JTextField();
		txtDigiteOCdigo.setText("Digite o código do Cliente...");
		txtDigiteOCdigo.setBounds(454, 108, 167, 20);
		contentPane.add(txtDigiteOCdigo);
		txtDigiteOCdigo.setColumns(10);
		
		tf_seq = new JTextField();
		tf_seq.setBounds(9, 524, 86, 20);
		contentPane.add(tf_seq);
		tf_seq.setColumns(10);
		
		tf_tip = new JTextField();
		tf_tip.setBounds(127, 524, 86, 20);
		contentPane.add(tf_tip);
		tf_tip.setColumns(10);
		
		tf_status_ch = new JTextField();
		tf_status_ch.setBounds(238, 524, 86, 20);
		contentPane.add(tf_status_ch);
		tf_status_ch.setColumns(10);
		
		lblSequencial = new JLabel("Sequencial:");
		lblSequencial.setBounds(9, 492, 65, 14);
		contentPane.add(lblSequencial);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(127, 492, 46, 14);
		contentPane.add(lblTipo);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setBounds(238, 492, 46, 14);
		contentPane.add(lblStatus);
		
		lblPrioridade_1 = new JLabel("Descrição:");
		lblPrioridade_1.setBounds(347, 492, 65, 14);
		contentPane.add(lblPrioridade_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 521, 386, 129);
		contentPane.add(scrollPane);
		
		textAreaDesc = new JTextArea();
		scrollPane.setViewportView(textAreaDesc);
		
		tf_prio = new JTextField();
		tf_prio.setBounds(9, 575, 86, 20);
		contentPane.add(tf_prio);
		tf_prio.setColumns(10);
		
		tf_mat_sup = new JTextField();
		tf_mat_sup.setBounds(127, 575, 86, 20);
		contentPane.add(tf_mat_sup);
		tf_mat_sup.setColumns(10);
		
		tf_mat_tec_int = new JTextField();
		tf_mat_tec_int.setBounds(238, 575, 86, 20);
		contentPane.add(tf_mat_tec_int);
		tf_mat_tec_int.setColumns(10);
		
		tf_mat_aten = new JTextField();
		tf_mat_aten.setBounds(9, 630, 86, 20);
		contentPane.add(tf_mat_aten);
		tf_mat_aten.setColumns(10);
		
		tf_num_ord_serv = new JTextField();
		tf_num_ord_serv.setBounds(127, 630, 86, 20);
		contentPane.add(tf_num_ord_serv);
		tf_num_ord_serv.setColumns(10);
		
		tf_cod_cli = new JTextField();
		tf_cod_cli.setBounds(238, 630, 86, 20);
		contentPane.add(tf_cod_cli);
		tf_cod_cli.setColumns(10);
		
		tf_id_aten = new JTextField();
		tf_id_aten.setBounds(9, 674, 86, 20);
		contentPane.add(tf_id_aten);
		tf_id_aten.setColumns(10);
		
		tf_dat_aber = new JTextField();
		tf_dat_aber.setBounds(127, 674, 86, 20);
		contentPane.add(tf_dat_aber);
		tf_dat_aber.setColumns(10);
		
		JLabel lblPrioridade_2 = new JLabel("Prioridade:");
		lblPrioridade_2.setBounds(9, 555, 65, 14);
		contentPane.add(lblPrioridade_2);
		
		JLabel lblMatSupervisor = new JLabel("Mat Supervisor:");
		lblMatSupervisor.setBounds(127, 555, 86, 14);
		contentPane.add(lblMatSupervisor);
		
		JLabel lblMatTecInterno = new JLabel("Mat Tec. Interno:");
		lblMatTecInterno.setBounds(238, 555, 93, 14);
		contentPane.add(lblMatTecInterno);
		
		JLabel lblMatAtendente = new JLabel("Mat Atendente:");
		lblMatAtendente.setBounds(9, 606, 93, 14);
		contentPane.add(lblMatAtendente);
		
		JLabel lblNumOrdemServico = new JLabel("Num Ordem Servico:");
		lblNumOrdemServico.setBounds(127, 606, 102, 14);
		contentPane.add(lblNumOrdemServico);
		
		JLabel lblCodCliente = new JLabel("Cod Cliente:");
		lblCodCliente.setBounds(238, 606, 71, 14);
		contentPane.add(lblCodCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Id Atendimento:");
		lblNewLabel_2.setBounds(9, 650, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data abertura:");
		lblNewLabel_3.setBounds(127, 650, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCadastrar_1 = new JButton("Cadastrar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado c = new Chamado();
				c.setSequencial(Long.parseLong(tf_seq.getText()));
				c.setTipo(tf_tip.getText());
				c.setStatusChamado(tf_status_ch.getText());
				c.setDescricao(textAreaDesc.getText());
				c.setPrioridade(tf_prio.getText());
				c.setMatSupervisor(tf_mat_sup.getText());
				c.setMatTecInterno(tf_mat_tec_int.getText());
				c.setMatAtendente(tf_mat_aten.getText());
				c.setNumOrdemServico(Long.parseLong(tf_num_ord_serv.getText()));
				c.setCodCliente(Long.parseLong(tf_cod_cli.getText()));
				c.setIdAtendimento(Long.parseLong(tf_id_aten.getText()));
				c.setDataAbertura(tf_dat_aber.getText());
				Fachada fch = Fachada.getInstance();

				fch.cadastrarChamado(c);
				
				readJTable2ForCod();
			}
		});
		btnCadastrar_1.setBounds(322, 673, 91, 23);
		contentPane.add(btnCadastrar_1);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado c = new Chamado();
				c.setSequencial(Long.parseLong(tf_seq.getText()));
				c.setTipo(tf_tip.getText());
				c.setStatusChamado(tf_status_ch.getText());
				c.setDescricao(textAreaDesc.getText());
				c.setPrioridade(tf_prio.getText());
				c.setMatSupervisor(tf_mat_sup.getText());
				c.setMatTecInterno(tf_mat_tec_int.getText());
				c.setMatAtendente(tf_mat_aten.getText());
				c.setNumOrdemServico(Long.parseLong(tf_num_ord_serv.getText()));
				c.setCodCliente(Long.parseLong(tf_cod_cli.getText()));
				c.setIdAtendimento(Long.parseLong(tf_id_aten.getText()));
				c.setDataAbertura(tf_dat_aber.getText());
				Fachada fch = Fachada.getInstance();
				fch.removerChamado(c);
				
				readJTable2ForCod();
			}
		});
		btnRemover.setBounds(423, 673, 91, 23);
		contentPane.add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(524, 673, 91, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnLimparCampos_1 = new JButton("Limpar Campos");
		btnLimparCampos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_seq.setText("");
				tf_tip.setText("");
				tf_status_ch.setText("");
				textAreaDesc.setText("");
				tf_prio.setText("");
				tf_mat_sup.setText("");
				tf_mat_tec_int.setText("");
				tf_mat_aten.setText("");
				tf_num_ord_serv.setText("");
				tf_cod_cli.setText("");
				tf_id_aten.setText("");
				tf_dat_aber.setText("");
			}
		});
		btnLimparCampos_1.setBounds(625, 673, 116, 23);
		contentPane.add(btnLimparCampos_1);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(85);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(142);
		table_2.getColumnModel().getColumn(6).setPreferredWidth(81);
		table_2.getColumnModel().getColumn(7).setResizable(true);
		table_2.getColumnModel().getColumn(7).setPreferredWidth(110);
		table_2.getColumnModel().getColumn(10).setPreferredWidth(126);

		table_2.getTableHeader().setReorderingAllowed(false);

		try {
			readJTable2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setResizable(true);

	}
	
	
	//carrega a tabela de Chamado
	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();
		modelo.setNumRows(0);
		Fachada fch = Fachada.getInstance();

		for (Chamado c : fch.listarTodosChamados()) {

			modelo.addRow(new Object[]{
					c.getSequencial(),
					c.getTipo(),
					c.getStatusChamado(),
					c.getDescricao(),
					c.getPrioridade(),
					c.getMatSupervisor(),
					c.getMatTecInterno(),
					c.getMatAtendente(),
					c.getNumOrdemServico(),
					c.getCodCliente(),
					c.getIdAtendimento(),
					c.getDataAbertura()
			});
		}
	}

	private void tbl_ChamadoMouseClicked(java.awt.event.MouseEvent evt){
		if (table_2.getSelectedRow() != -1) {

			tf_seq.setText(table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
			tf_tip.setText(table_2.getValueAt(table_2.getSelectedRow(), 1).toString());
			tf_status_ch.setText(table_2.getValueAt(table_2.getSelectedRow(), 2).toString());
			textAreaDesc.setText(table_2.getValueAt(table_2.getSelectedRow(), 3).toString());
			tf_prio.setText(table_2.getValueAt(table_2.getSelectedRow(), 4).toString());
			tf_mat_sup.setText(table_2.getValueAt(table_2.getSelectedRow(), 5).toString());
			tf_mat_tec_int.setText(table_2.getValueAt(table_2.getSelectedRow(), 6).toString());
			tf_mat_aten.setText(table_2.getValueAt(table_2.getSelectedRow(), 7).toString());
			tf_num_ord_serv.setText(table_2.getValueAt(table_2.getSelectedRow(), 8).toString());
			tf_cod_cli.setText(table_2.getValueAt(table_2.getSelectedRow(), 9).toString());
			tf_id_aten.setText(table_2.getValueAt(table_2.getSelectedRow(), 10).toString());
			tf_dat_aber.setText(table_2.getValueAt(table_2.getSelectedRow(), 11).toString());


		}

	}

	private void tbl_ChamadoKeyReleased(java.awt.event.KeyEvent evt) {
		if (table_2.getSelectedRow() != -1) {

			tf_seq.setText(table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
			tf_tip.setText(table_2.getValueAt(table_2.getSelectedRow(), 1).toString());
			tf_status_ch.setText(table_2.getValueAt(table_2.getSelectedRow(), 2).toString());
			textAreaDesc.setText(table_2.getValueAt(table_2.getSelectedRow(), 3).toString());
			tf_prio.setText(table_2.getValueAt(table_2.getSelectedRow(), 4).toString());
			tf_mat_sup.setText(table_2.getValueAt(table_2.getSelectedRow(), 5).toString());
			tf_mat_tec_int.setText(table_2.getValueAt(table_2.getSelectedRow(), 6).toString());
			tf_mat_aten.setText(table_2.getValueAt(table_2.getSelectedRow(), 7).toString());
			tf_num_ord_serv.setText(table_2.getValueAt(table_2.getSelectedRow(), 8).toString());
			tf_cod_cli.setText(table_2.getValueAt(table_2.getSelectedRow(), 9).toString());
			tf_id_aten.setText(table_2.getValueAt(table_2.getSelectedRow(), 10).toString());
			tf_dat_aber.setText(table_2.getValueAt(table_2.getSelectedRow(), 10).toString());

		}
	}




	private void tbl_ClienteMouseClicked(java.awt.event.MouseEvent evt){
		if (table_1.getSelectedRow() != -1) {

			txtCod.setText(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
			txtPrioridade.setText(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
			txtEndereco.setText(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
			txtEstado.setText(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
			txtEmail.setText(table_1.getValueAt(table_1.getSelectedRow(), 4).toString());
			txtFone.setText(table_1.getValueAt(table_1.getSelectedRow(), 5).toString());

			readJTable2ForCod();
		}

	}

	private void tbl_ClienteKeyReleased(java.awt.event.KeyEvent evt) {
		if (table_1.getSelectedRow() != -1) {

			txtCod.setText(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
			txtPrioridade.setText(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
			txtEndereco.setText(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
			txtEstado.setText(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
			txtEmail.setText(table_1.getValueAt(table_1.getSelectedRow(), 4).toString());
			txtFone.setText(table_1.getValueAt(table_1.getSelectedRow(), 5).toString());
			
			readJTable2ForCod();
		}

	}	 


	public void readJTable2() throws Exception {

		DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
		modelo.setNumRows(0);
		Fachada fch = Fachada.getInstance();

		for (Cliente cl : fch.listarTodosClientes()) {

			modelo.addRow(new Object[]{
					cl.getCod(),
					cl.getPrioridade(),
					cl.getEndereco(),
					cl.getEstado(),
					cl.getEmail(),
					cl.getFone()


			});
		}
	}
	
	//carreaga a JTable2(Chamado) a partir dos dados selecionados na linha da JTable1(Cliente)
	public void readJTable2ForCod() {
		Fachada fch = Fachada.getInstance();
		List<Chamado> chamados = new ArrayList<>();
		
		chamados = fch.listarChamadoPorCodCliente(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
		
		
		DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();
		modelo.setNumRows(0);

		for (Chamado c : chamados) {
			modelo.addRow(new Object[]{
					c.getSequencial(),
					c.getTipo(),
					c.getStatusChamado(),
					c.getDescricao(),
					c.getPrioridade(),
					c.getMatSupervisor(),
					c.getMatTecInterno(),
					c.getMatAtendente(),
					c.getNumOrdemServico(),
					c.getCodCliente(),
					c.getIdAtendimento(),
					c.getDataAbertura()
			});
		}
	}
	
	public void readJTableForCod(String str) {
		Fachada fch = Fachada.getInstance();
		DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
		modelo.setNumRows(0);

		for (Cliente cl : fch.listarClientePorCod(str)) {
			modelo.addRow(new Object[]{
					cl.getCod(),
					cl.getPrioridade(),
					cl.getEndereco(),
					cl.getEstado(),
					cl.getEmail(),
					cl.getFone()
			});}

	}

	private void preencherFormulario(){
		txtCod.setText(table_1.getValueAt(0, 0).toString());
		txtPrioridade.setText(table_1.getValueAt(0, 1).toString());
		txtEndereco.setText(table_1.getValueAt(0, 2).toString());
		txtEstado.setText(table_1.getValueAt(0, 3).toString());
		txtEmail.setText(table_1.getValueAt(0, 4).toString());
		txtFone.setText(table_1.getValueAt(0, 5).toString());

	}
}
