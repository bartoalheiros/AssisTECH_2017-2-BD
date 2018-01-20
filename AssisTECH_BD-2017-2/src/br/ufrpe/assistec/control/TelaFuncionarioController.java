/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.assistec.control;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrpe.assistec.model.Funcionario;
import br.ufrpe.assistec.service.IRepositorioFuncionarios;
import br.ufrpe.assistec.service.RepositorioFuncionarios;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author BARTOLOMEU.DIAS
 */
public class TelaFuncionarioController {

	@FXML
	private TextField tf_MatriculaF;

	@FXML
	private TextField tf_Matricula_Superv;

	@FXML
	private TextField tf_Cpf;

	@FXML
	private TextField tf_CNPJ_Empregador;

	@FXML
	private TextField tf_Email;

	@FXML
	private TextField tf_consulta;

	@FXML
	private Button btn_Cadastrar;

	@FXML
	private Button btn_Exibir;
	
	@FXML
	private Button btn_Salvar;
	
	@FXML
	private TextField tf_Login;

	@FXML
	private TextField tf_Senha;

	@FXML
	private TextField tf_Nome;

	@FXML
	private TextField tf_Cod_Unid_Suporte;

	@FXML
	private TextField tf_Carga_hora;
	
	@FXML
	private TextField tf_Data_Inicio;
	
	@FXML
	private TextField tf_ID_Jornada;

	@FXML
	private TableView<Funcionario> tableFuncionario;

	@FXML
	private TableColumn<Funcionario,String> cl_MatriculaFuncionario;

	@FXML
	private TableColumn<Funcionario,String> cl_MatriculaSupervisor;

	@FXML
	private TableColumn<Funcionario,String> cl_Nome;

	@FXML
	private TableColumn<Funcionario,Long> cl_CPF;

	@FXML
	private TableColumn<Funcionario,Integer> cl_Cod_Unid_Suporte;

	@FXML
	private TableColumn<Funcionario,Long> cl_Carga_hora;

	@FXML
	private TableColumn<Funcionario,String> cl_Email;

	@FXML
	private TableColumn<Funcionario,String> cl_Login;
	
	@FXML
	private TableColumn<Funcionario,String> cl_Senha;
	
	@FXML
	private TableColumn<Funcionario,Date> cl_DataInicio;
	
	@FXML
	private TableColumn<Funcionario,String> cl_ID_Jornada;
	
	private IRepositorioFuncionarios repFunc = RepositorioFuncionarios.getInstance();
	
	private List<Funcionario> employeeList = repFunc.lista();
	
	private ObservableList<Funcionario> employeeTableList = FXCollections.observableArrayList();

	public void initialize() {
		
		//lista os funcionários na tabela
		this.listar_Funcionarios();
		
	}

	//método adaptado para mostrar os campos de um funcionário informado pelo usuário
	//seria melhor o nome 'buscar'
	@FXML
	void busca() {   
		try {
			Funcionario funcionario = this.repFunc.busca(tf_consulta.getText());

			if (funcionario == null ){
				Alert err = new Alert(AlertType.ERROR);
				err.setContentText("Nenhum funcionário cadastrado.");
				err.showAndWait();

			}
			else{
				//tableFuncionario.setItems(FXCollections.observableList(listaFuncionarios));
				tf_MatriculaF.setText(funcionario.getMatricula());
				tf_MatriculaF.setEditable(false);
				tf_Matricula_Superv.setText(funcionario.getMatriculaSuperv());
				tf_Matricula_Superv.setEditable(false);
				tf_Cpf.setText(Long.toString(funcionario.getCPF()));
				tf_Cpf.setEditable(false);
				tf_Email.setText(funcionario.getEmail());
				tf_Email.setEditable(false);
				tf_Login.setText(funcionario.getLogin());
				tf_Login.setEditable(false);
				tf_Senha.setText(funcionario.getSenha());
				tf_Senha.setEditable(false);
				tf_Nome.setText(funcionario.getNome());
				tf_Nome.setEditable(false);
				tf_Cod_Unid_Suporte.setText(Integer.toString(funcionario.getCodUnid_Suporte()));
				tf_Cod_Unid_Suporte.setEditable(false);
				tf_Carga_hora.setText(Integer.toString(funcionario.getCargaHoraria()));
				tf_Carga_hora.setEditable(false);
				
			}

		} catch (Exception e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText("Falha ao realizar consulta");
			err.showAndWait();
			e.printStackTrace();
		}

	}

	@FXML
	void listar_Funcionarios() {
		
		cl_MatriculaFuncionario.setCellValueFactory(new PropertyValueFactory<>("Matricula"));
		cl_CPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		cl_Login.setCellValueFactory(new PropertyValueFactory<>("Login"));
		cl_Senha.setCellValueFactory(new PropertyValueFactory<>("Senha"));
		cl_Nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		cl_Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
		cl_Carga_hora.setCellValueFactory(new PropertyValueFactory<>("CargaHoraria"));
		cl_MatriculaSupervisor.setCellValueFactory(new PropertyValueFactory<>("MatriculaSupervisor"));
		cl_ID_Jornada.setCellValueFactory(new PropertyValueFactory<>("IdJornada"));
		cl_DataInicio.setCellValueFactory(new PropertyValueFactory<>("DataInicio"));
		cl_Cod_Unid_Suporte.setCellValueFactory(new PropertyValueFactory<>("CodigoUnidadeDeSuporte"));
		
		
		if(!employeeTableList.isEmpty()) {
			employeeTableList.clear();
		}
		
		
		
		for(Funcionario funcionario : employeeList) {
					employeeTableList.add(funcionario);
					//System.out.println(funcionario);
				
		}
		
		
		tableFuncionario.setItems(employeeTableList);
		//tableFuncionario.getColumns().addAll(cl_MatriculaFuncionario, cl_CPF, cl_Login, cl_Senha, cl_Nome, cl_Email, cl_Carga_hora, cl_MatriculaSupervisor, cl_ID_Jornada, cl_DataInicio, cl_Cod_Unid_Suporte);
	}
	
	@FXML
	void editarFuncionario() {
		tf_MatriculaF.setEditable(true);
		tf_Matricula_Superv.setEditable(true);
		tf_Cpf.setEditable(true);
		tf_CNPJ_Empregador.setEditable(true);
		tf_Email.setEditable(true);
		tf_Login.setEditable(true);
		tf_Nome.setEditable(true);
		tf_Cod_Unid_Suporte.setEditable(true);
		tf_Carga_hora.setEditable(true);

		Alert infoEditarFunc = new Alert(Alert.AlertType.INFORMATION);
		infoEditarFunc.setHeaderText("Editar Funcionário");
		infoEditarFunc.setContentText("Edite os dados nos campos e clique em 'Salvar Alterações'");
		infoEditarFunc.showAndWait();
	}
	
	@FXML
	void atualiza(ActionEvent event) {
		
		java.text.DateFormat format = java.text.DateFormat.getDateInstance();
		
		Funcionario f = null;
		
		try {
			f = new Funcionario(tf_MatriculaF.getText(), tf_Matricula_Superv.getText(), tf_Nome.getText(), 
					Long.parseLong(tf_Cpf.getText()), Integer.parseInt(tf_Cod_Unid_Suporte.getText()), 
					tf_Login.getText(), tf_Senha.getText(), tf_Email.getText(), Integer.parseInt(tf_Carga_hora.getText()),  (Date) format.parse(tf_Data_Inicio.getText()), tf_ID_Jornada.getText());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			this.repFunc.atualiza(f);
			Alert infoAlterar = new Alert(AlertType.INFORMATION);
			infoAlterar.setContentText("Atualizado com sucesso!");
			infoAlterar.showAndWait();
		} catch (SQLException e) {
			Alert infoAlterar = new Alert(AlertType.INFORMATION);
			infoAlterar.setContentText("Falha ao alterar dados");
			infoAlterar.showAndWait();
			e.printStackTrace();
		}
	}

	
	//cadastra um funcionário no banco
	@FXML
	void cadastra(ActionEvent event) {
		
		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 

		Funcionario func = null;
		try {
			func = new Funcionario(tf_MatriculaF.getText(), tf_Matricula_Superv.getText(), tf_Nome.getText(), 
					Long.parseLong(tf_Cpf.getText()), Integer.parseInt(tf_Cod_Unid_Suporte.getText()), 
					tf_Login.getText(), tf_Senha.getText(), tf_Email.getText(), Integer.parseInt(tf_Carga_hora.getText()), (Date) format.parse(tf_Data_Inicio.getText()), tf_ID_Jornada.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.repFunc.cadastra(func);
	}

}


