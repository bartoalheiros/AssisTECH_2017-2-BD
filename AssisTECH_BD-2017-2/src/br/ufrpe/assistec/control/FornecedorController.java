package br.ufrpe.assistec.control;

import java.util.List;

import br.ufrpe.assistec.model.Fornecedor;
import br.ufrpe.assistec.model.Funcionario;
import br.ufrpe.assistec.service.IRepositorioFornecedor;
import br.ufrpe.assistec.service.IRepositorioFuncionarios;
import br.ufrpe.assistec.service.RepositorioFornecedor;
import br.ufrpe.assistec.service.RepositorioFuncionarios;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FornecedorController {
	@FXML
	private TextField tf_CNPJ;
	
	@FXML
	private TextField tf_RazaoSocial;
	
	@FXML
	private TextField tf_Email;
	
	@FXML
	private TextField tf_Telefone;
	
	@FXML
	private TextField tf_BuscarFornecedor;
	
	@FXML
	private TableColumn<Fornecedor,Long> cl_CNPJ;
	
	@FXML
	private TableColumn<Fornecedor,String> cl_Razao_Social;
	
	@FXML
	private TableColumn<Fornecedor,String> cl_Email;
	
	@FXML
	private TableColumn<Fornecedor,String> cl_Telefone;
	
	@FXML
	private TableView<Fornecedor> tbl_Fornecedor;
	
	private IRepositorioFornecedor repForn = RepositorioFornecedor.getInstance();
	
	private ObservableList<Fornecedor> fornecedorTableList = FXCollections.observableArrayList();
	
	private List<Fornecedor> fornecedorList = repForn.lista();
	
	
	public void initialize() {
		
		//lista os funcionários na tabela
		this.listar_Fornecedores();
		
	}
	
	@FXML
	void listar_Fornecedores() {
		
		
		if(!fornecedorTableList.isEmpty()) {
			fornecedorTableList.clear();
		}
		
		
		
		for(Fornecedor fornecedor : fornecedorList) {
					fornecedorTableList.add(fornecedor);
					System.out.println(fornecedor);
				
		}
		
		cl_CNPJ.setCellValueFactory(new PropertyValueFactory<Fornecedor,Long>("Cnpj"));
		cl_Razao_Social.setCellValueFactory(new PropertyValueFactory<Fornecedor,String>("Razao_social"));
		cl_Email.setCellValueFactory(new PropertyValueFactory<Fornecedor,String>("Email"));
		cl_Telefone.setCellValueFactory(new PropertyValueFactory<Fornecedor,String>("Telefone"));
		
		tbl_Fornecedor.setItems(fornecedorTableList);
		//tableFuncionario.getColumns().addAll(cl_MatriculaFuncionario, cl_CPF, cl_Login, cl_Senha, cl_Nome, cl_Email, cl_Carga_hora, cl_MatriculaSupervisor, cl_ID_Jornada, cl_DataInicio, cl_Cod_Unid_Suporte);
	}
	
}
