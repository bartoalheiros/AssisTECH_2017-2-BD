   
package br.ufrpe.bds.assistech.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufrpe.bds.assistech.model.bean.Cliente;
import br.ufrpe.bds.assistech.model.bean.Fatura;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;
import br.ufrpe.bds.assistech.model.bean.OrdemServico;
import br.ufrpe.bds.assistech.model.bean.ParcelaPagamentoFatura;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class GerenciamentoOrdemServicoView<E> extends JFrame {

	private JPanel contentPane;
	private JTextField tf_praDias;
	private JTextField tf_dtCria;
	private JTextField tf_status;
	private JTable table;
	private JList list;
	List<OrdemServico> os = new ArrayList<>();
	private JTextField tfNumOs;
	private JTextField tf_numOrdSer;
	private JTextField tf_dtDevida;
	private JTextField tf_codOrc;
	private JTextField tf_codFat;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoOrdemServicoView frame = new GerenciamentoOrdemServicoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GerenciamentoOrdemServicoView() {
		initComponents();
	}

	private void initComponents(){
		setTitle("Gerenciar Ordem de Servico");
		setBounds(100, 100, 884, 821);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf_praDias = new JTextField();
		tf_praDias.setBounds(236, 75, 86, 20);
		contentPane.add(tf_praDias);
		tf_praDias.setColumns(10);

		tf_dtCria = new JTextField();
		tf_dtCria.setBounds(331, 75, 86, 20);
		contentPane.add(tf_dtCria);
		tf_dtCria.setColumns(10);

		tf_status = new JTextField();
		tf_status.setBounds(424, 75, 86, 20);
		contentPane.add(tf_status);
		tf_status.setColumns(10);

		JLabel lblCod = new JLabel("Ordem servico:");
		lblCod.setBounds(20, 143, 91, 14);
		contentPane.add(lblCod);

		JLabel lblNroParcelas = new JLabel("Prazo em dias:");
		lblNroParcelas.setBounds(236, 50, 86, 14);
		contentPane.add(lblNroParcelas);

		JLabel lblNewLabel = new JLabel("Data criação:");
		lblNewLabel.setBounds(333, 50, 84, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Status:");
		lblNewLabel_1.setBounds(424, 50, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cod. or\u00E7amento:");
		lblNewLabel_2.setBounds(20, 297, 86, 14);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 375, 862, 181);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Cod", "Data_entrada", "Setor", "Historico", "Fabricante", "Estado", "Descricao", "Cod_contrato", "Cnpj_Unidade_Suporte", "Cod_Cliente", "Data_nicio"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setPreferredWidth(93);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(88);
		scrollPane.setViewportView(table);

		JLabel lblParcelas = new JLabel("Equipamentos:");
		lblParcelas.setBounds(20, 354, 114, 14);
		contentPane.add(lblParcelas);

		JLabel lblFatura = new JLabel("Ordem servico:");
		lblFatura.setBounds(20, 22, 80, 14);
		contentPane.add(lblFatura);

		tfNumOs = new JTextField();
		tfNumOs.setBounds(747, 75, 86, 20);
		contentPane.add(tfNumOs);
		tfNumOs.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Cod Chamado:");
		lblNewLabel_3.setBounds(747, 50, 86, 14);
		contentPane.add(lblNewLabel_3);

		JComboBox cbOrcamento = new JComboBox();
		cbOrcamento.setBounds(20, 321, 86, 22);
		contentPane.add(cbOrcamento);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 171, 389, 118);
		contentPane.add(scrollPane_1);
		
				list = new JList();
				scrollPane_1.setViewportView(list);
				
						list.addMouseListener(new java.awt.event.MouseAdapter() {
							public void mouseClicked(java.awt.event.MouseEvent evt) {
								list_MouseClicked(evt);
							}
						});

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrdemServico o = new OrdemServico();

				o.setNumOS(Long.parseLong(tf_numOrdSer.getText()));
				o.setDtDevida(tf_dtDevida.getText());
				o.setPrazoEmDias(Long.parseLong(tf_praDias.getText()));
				o.setDtCriacao(tf_dtCria.getText());
				o.setStatus(tf_status.getText());
				o.setCodOrcamento(Long.parseLong(tf_codOrc.getText()));
				o.setCodFatura(Long.parseLong(tf_codFat.getText()));

				Fachada fch = Fachada.getInstance();
				fch.cadastrarOrdemServico(o);

				os = fch.listarOrdemServicoPorNumOS(cbOrcamento.getSelectedItem().toString());
				list.setListData(os.toArray());
			}
		});
		btnCadastrar.setBounds(20, 111, 91, 23);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar");
		/*btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada fch = Fachada.getInstance();
				OrdemServico os = new OrdemServico();
				
				os.setNumOrdemServico(Long.parseLong(tf_numOrdSer.getText()));
				os.setDataDevida(tf_dtDevida.getText());
				os.setPrazoDias(Long.parseLong(tf_praDias.getText()));
				os.setDataCriacao(tf_dtCria.getText());
				os.setStatus(tf_status.getText());
				os.setCodOrcamento(Long.parseLong(tf_codOrc.getText()));
				os.setNumOrdemServico(Long.parseLong(tf_codFat.getText()));
				
				fch.atualizarOrdemServico(os);
				
				os = fch.listarOrdemServicoPorNum_Ordem_Servico(cbOrcamento.getSelectedItem().toString());
				list.setListData(os.toArray());
			}
		});*/
		btnAlterar.setBounds(121, 111, 91, 23);
		contentPane.add(btnAlterar);

		JButton btnRemover = new JButton("Remover");
		/*btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fch = Fachada.getInstance();
				
				OrdemServico os = new OrdemServico();
				os.setNumOrdemSevico(Long.parseLong(tf_numOrdSer.getText()));

				fch.removerOrdemServico(os);
				
				os = fch.listarOrdemServicoPorNum_Ordem_Servico(cbOrcamento.getSelectedItem().toString());
				list.setListData(os.toArray());
			}
		});*/
		btnRemover.setBounds(225, 111, 91, 23);
		contentPane.add(btnRemover);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf_numOrdSer.setText("");
				tf_dtDevida.setText("");
				tf_praDias.setText("");
				tf_dtCria.setText("");
				tf_status.setText("");
				tfNumOs.setText("");
			}
		});
		btnLimparCampos.setBounds(331, 111, 109, 23);
		contentPane.add(btnLimparCampos);

		tf_numOrdSer = new JTextField();
		tf_numOrdSer.setBounds(20, 75, 114, 20);
		contentPane.add(tf_numOrdSer);
		tf_numOrdSer.setColumns(10);

		JLabel lblCod_1 = new JLabel("Data devida:");
		lblCod_1.setBounds(142, 50, 70, 14);
		contentPane.add(lblCod_1);

		JLabel lbCodFatura = new JLabel("Numero ordem servico:");
		lbCodFatura.setBounds(20, 50, 114, 14);
		contentPane.add(lbCodFatura);

		tf_dtDevida = new JTextField();
		tf_dtDevida.setBounds(142, 75, 86, 20);
		contentPane.add(tf_dtDevida);
		tf_dtDevida.setColumns(10);
		
		JLabel lblCodOrcamento_1 = new JLabel("Cod. orcamento:");
		lblCodOrcamento_1.setBounds(518, 50, 83, 14);
		contentPane.add(lblCodOrcamento_1);
		
		JLabel lblCodOrcamento = new JLabel("Cod. fatura:");
		lblCodOrcamento.setBounds(614, 50, 83, 14);
		contentPane.add(lblCodOrcamento);
		
		tf_codOrc = new JTextField();
		tf_codOrc.setColumns(10);
		tf_codOrc.setBounds(517, 75, 86, 20);
		contentPane.add(tf_codOrc);
		
		tf_codFat = new JTextField();
		tf_codFat.setColumns(10);
		tf_codFat.setBounds(611, 74, 86, 20);
		contentPane.add(tf_codFat);
		
		textField = new JTextField();
		textField.setBounds(20, 608, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 608, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(225, 608, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(321, 608, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(424, 608, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(20, 667, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(126, 667, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(230, 667, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(331, 667, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(424, 667, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblCod_2 = new JLabel("Cod:");
		lblCod_2.setBounds(20, 583, 46, 14);
		contentPane.add(lblCod_2);
		
		JLabel lblDataEntrada = new JLabel("Data Entrada:");
		lblDataEntrada.setBounds(127, 583, 70, 14);
		contentPane.add(lblDataEntrada);
		
		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(225, 583, 46, 14);
		contentPane.add(lblSetor);
		
		JLabel lblHistorico = new JLabel("Historico:");
		lblHistorico.setBounds(321, 583, 46, 14);
		contentPane.add(lblHistorico);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(423, 583, 70, 14);
		contentPane.add(lblFabricante);
		
		JLabel lblNewLabel_4 = new JLabel("Estado:");
		lblNewLabel_4.setBounds(20, 639, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblDescricao = new JLabel("Descricao:");
		lblDescricao.setBounds(121, 639, 70, 14);
		contentPane.add(lblDescricao);
		
		JLabel lblCnpjUnidadeSuporte = new JLabel("Cnpj Unid Suporte:");
		lblCnpjUnidadeSuporte.setBounds(331, 639, 97, 14);
		contentPane.add(lblCnpjUnidadeSuporte);
		
		JLabel lblCodContrato = new JLabel("Cod Contrato:");
		lblCodContrato.setBounds(235, 639, 70, 14);
		contentPane.add(lblCodContrato);
		
		JLabel lblCodCliente = new JLabel("Cod Cliente:");
		lblCodCliente.setBounds(434, 639, 76, 14);
		contentPane.add(lblCodCliente);
		
		textField_10 = new JTextField();
		textField_10.setBounds(535, 667, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setBounds(535, 639, 66, 14);
		contentPane.add(lblDataInicio);
		
		JButton btnCadastrar_1 = new JButton("Cadastrar");
		btnCadastrar_1.setBounds(20, 715, 91, 23);
		contentPane.add(btnCadastrar_1);
		
		JButton btnRemover_1 = new JButton("Remover");
		btnRemover_1.setBounds(121, 715, 91, 23);
		contentPane.add(btnRemover_1);
		
		JButton btnLimparCampos_1 = new JButton("Limpar Campos");
		btnLimparCampos_1.setBounds(331, 715, 124, 23);
		contentPane.add(btnLimparCampos_1);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(220, 715, 91, 23);
		contentPane.add(btnAtualizar);
		
		textField_11 = new JTextField();
		textField_11.setBounds(465, 716, 155, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(630, 715, 91, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(465, 172, 373, 117);
		contentPane.add(scrollPane_2);
		
		JList list_1 = new JList();
		scrollPane_2.setViewportView(list_1);
		
		JLabel lblServico = new JLabel("Serviços:");
		lblServico.setBounds(465, 143, 46, 14);
		contentPane.add(lblServico);

		Fachada fch = Fachada.getInstance();

		//carrega combobox de cliente
		for(Cliente c: fch.listarTodosClientes()){
			cbOrcamento.addItem(c);
		}

		/*cbOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				os = fch.listarOrdemServicoPorNum_Ordem_Servico(cbOrcamento.getSelectedItem().toString());
				list.setListData(os.toArray());
			}
		});*/
		
		setResizable(true);
	}


	private void list_MouseClicked(java.awt.event.MouseEvent evt){
		if (list.getSelectedIndex()!=-1) {
			String str = list.getSelectedValue().toString();
			Fachada fch = Fachada.getInstance();

			/*for (OrdemServico os : fch.listarOrdemServicoPorNum_Ordem_Servico(str)) {

				os.setNumOrdemServico(Long.parseLong(tf_numOrdSer.getText()));
				os.setDataDevida(tf_dtDevida.getText());
				os.setPrazoDias(Long.parseLong(tf_praDias.getText()));
				os.setDataCriacao(tf_dtCria.getText());
				os.setStatus(tf_status.getText());
				os.setCodOrcamento(Long.parseLong(tf_codOrc.getText()));
				os.setNumOrdemServico(Long.parseLong(tf_codFat.getText()));
			}*/


			//para mudar o tf_NumOS quando a pessoa clicar na lita de Faturas.
			//Pois cada fatura pertence a uma únicas OS.
			/*for (OrdemServico os : fch.listarOrdemServicoPorNum_Ordem_Servico(str)) {

				tfNumOs.setText(Long.toString(os.getNumOS()));
			}*/

			readJTableForNum_Ordem_servico(str);

		}

	}

	
	
	
	
	
	
	
	public void readJTableForNum_Ordem_servico(String str) {
		Fachada fch = Fachada.getInstance();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);

		for (ParcelaPagamentoFatura pc : fch.listarParcelasPgtoFaturaPorCodFatura(str)) {
			modelo.addRow(new Object[]{
					pc.getSeqParcelaPgto(),
					pc.getCodFatura(),
					pc.getDtaPagto(),
					pc.getDtaParcela(),
					pc.getJuros(),
					pc.getValorTotal(),
					pc.getValorPgtoParcela()
			});}

	}
}