package view;

import java.sql.Connection;
import java.sql.SQLException;

import control.ControladorFornecedor;
import control.ControladorFuncionario;
import control.ControladorLogin;
import model.bean.Fornecedor;

public class Fachada {
	private static Fachada instance = null;
	private ControladorLogin login;
	private ControladorFornecedor fornecedores;
	private ControladorFuncionario funcionarios;
	
	
	public Fachada() {
		this.login = new ControladorLogin();
		this.fornecedores = new ControladorFornecedor();
		this.funcionarios = new ControladorFuncionario();
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
	
}
