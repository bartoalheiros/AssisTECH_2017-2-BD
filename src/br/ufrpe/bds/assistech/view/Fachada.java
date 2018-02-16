package br.ufrpe.bds.assistech.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.ufrpe.bds.assistech.control.ControladorChamado;
import br.ufrpe.bds.assistech.control.ControladorFornecedor;
import br.ufrpe.bds.assistech.control.ControladorFuncionario;
import br.ufrpe.bds.assistech.control.ControladorLogin;
import br.ufrpe.bds.assistech.model.bean.Chamado;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;
import br.ufrpe.bds.assistech.model.bean.Funcionario;

public class Fachada {
	private static Fachada instance = null;
	private ControladorLogin login;
	private ControladorFornecedor fornecedores;
	private ControladorFuncionario funcionarios;
	private ControladorChamado chamados;
	
	
	public Fachada() {
		this.login = new ControladorLogin();
		this.fornecedores = new ControladorFornecedor();
		this.funcionarios = new ControladorFuncionario();
		this.chamados = new ControladorChamado();
	}
	
	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	/** LOGIN */
	public void fecharConexao() throws SQLException {
		login.fecharConexao();
	}

	public void fazerLogin(String nome, String senha) throws Exception {
		login.fazerLogin(nome, senha);
	}

	public Connection getConnection() {
		return login.getConnection();
	}
	
	/** FORNECEDOR */
	public void cadastrarFornecedor(Fornecedor o){
		fornecedores.cadastrar(o);
	}
	
	public void removerFornecedor(Fornecedor o) {
		fornecedores.remover(o);
	}
	
	public List<Fornecedor> listarTodosFornecedores() {
		return fornecedores.listarTodos();
	}
	
	public  List<Fornecedor> listarFornecedorPorCnpj(String str) {
		return fornecedores.listarPorCnpj(str);
	}
	
	public void atualizarFornecedor(Fornecedor o) {
		fornecedores.atualizar(o);
	}
	
	/** FUNCIONARIO */
	public List<Funcionario> listarTodosFuncionarios() {
		return funcionarios.listarTodos();
	}
	
	public List<Funcionario> listarFuncionarioPorMatricula(String str) {
		return funcionarios.listarPorMatricula(str);
	}

	/** CHAMADO */
	
	public List<Chamado> listarTodosChamados() {
		return chamados.listarTodos();
	}

	public List<Chamado> listarChamadoPorSequencial(String str) {
		return chamados.listarPorSequencial(str);
	}
}
