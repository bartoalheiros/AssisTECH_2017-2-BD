package br.ufrpe.bds.assistech.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.ufrpe.bds.assistech.control.ControladorChamado;
import br.ufrpe.bds.assistech.control.ControladorCliente;
import br.ufrpe.bds.assistech.control.ControladorComponente;
import br.ufrpe.bds.assistech.control.ControladorComputador;
import br.ufrpe.bds.assistech.control.ControladorFatura;
import br.ufrpe.bds.assistech.control.ControladorFornecedor;
import br.ufrpe.bds.assistech.control.ControladorFuncionario;
import br.ufrpe.bds.assistech.control.ControladorLogin;
import br.ufrpe.bds.assistech.control.ControladorOrdemServico;
import br.ufrpe.bds.assistech.control.ControladorParcelaPagamentoFatura;
import br.ufrpe.bds.assistech.model.bean.Chamado;
import br.ufrpe.bds.assistech.model.bean.Cliente;
import br.ufrpe.bds.assistech.model.bean.Componente;
import br.ufrpe.bds.assistech.model.bean.Computador;
import br.ufrpe.bds.assistech.model.bean.Fatura;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;
import br.ufrpe.bds.assistech.model.bean.Funcionario;
import br.ufrpe.bds.assistech.model.bean.OrdemServico;
import br.ufrpe.bds.assistech.model.bean.ParcelaPagamentoFatura;

public class Fachada {
	private static Fachada instance = null;
	private ControladorLogin login;
	private ControladorFornecedor fornecedores;
	private ControladorFuncionario funcionarios;
	private ControladorChamado chamados;
	private ControladorComponente componentes;
	private ControladorFatura faturas;
	private ControladorCliente clientes;
	private ControladorOrdemServico ordensServico;
	private ControladorParcelaPagamentoFatura parcelasPagamentoFatura;
	private ControladorComputador computadores;


	private Fachada() {
		this.login = new ControladorLogin();
		this.fornecedores = new ControladorFornecedor();
		this.funcionarios = new ControladorFuncionario();
		this.chamados = new ControladorChamado();
		this.componentes = new ControladorComponente();
		this.faturas = new ControladorFatura();
		this.clientes = new ControladorCliente();
		this.ordensServico = new ControladorOrdemServico();
		this.parcelasPagamentoFatura = new ControladorParcelaPagamentoFatura();
		this.computadores = new ControladorComputador();
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
	public void cadastrarFuncionario(Funcionario f) {
		funcionarios.cadastrar(f);
	}

	public void removerFuncionario(Funcionario f) {
		funcionarios.remover(f);
	}

	public void atualizarFuncionario(Funcionario f) {
		funcionarios.atualizar(f);
	}

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
	
	public List<Chamado> listarChamadoPorCodCliente(String str) {
		return chamados.listarChamadoPorCodCliente(str);
	}

	public void cadastrarChamado(Chamado c) {
		chamados.cadastrar(c);
	}

	public void removerChamado(Chamado c) {
		chamados.remover(c);

	}

	public void atualizarChamado(Chamado o) {
		chamados.atualizar(o);
	}

	
	/** COMPUTADOR */
	public void cadastrarComputador(Computador o) {
		computadores.cadastrar(o);
	}
	
	public void removerComputador(Computador o) {
		computadores.remover(o);
	}
	
	public void atualizarComputador(Computador o) {
		computadores.atualizar(o);
	}
	
	public List<Computador> listarTodosComputadores() {
		return computadores.listarTodos();
	}
	
	public List<Computador> listarTodosComputadoresPorCod(String str) {
		return computadores.listarTodosPorCodigo(str);
	}
	
	/** COMPONENTE */
	public void cadastrarComponente(Componente co){
		componentes.cadastrar(co);
	}

	public void removerComponente(Componente co) {
		componentes.remover(co);
	}

	public List<Componente> listarTodosComponentes() {
		return componentes.listarTodos();
	}

	public  List<Componente> listarComponentePorCod(String str) {
		return componentes.listarPorCod(str);
	}

	public void atualizarComponente(Componente co) {
		componentes.atualizar(co);
	}

	/** CLIENTE */
	public List<Cliente> listarTodosClientes() {
		return clientes.listarTodos();
	}

	public void cadastrarCliente(Cliente o) {
		clientes.cadastrar(o);

	}
	
	public List<Cliente> listarClientePorCod(String str) {
		return clientes.listarClientePorCod(str);
	}

	/** FATURA */
	public List<Fatura> listarFaturaPorCodigo(String str) {
		return faturas.listarPorCodigo(str);
	}

	public List<Fatura> listarFaturasPorCodCliente(String str) {
		return faturas.listarPorCodCliente(str);
	}

	public void cadastrarFatura(Fatura o) {
		faturas.cadastrar(o);
	}

	public void removerFatura(Fatura o) {
		faturas.remover(o);
	}

	public void atualizarFatura(Fatura o) {
		faturas.atualizar(o);
	}

	/** OrdemServico */
	public List<OrdemServico> listarOrdemServicoPorCodFatura(String str) {
		return ordensServico.listarPorCodFatura(str);
	}

	/** Parcela Pagamento Fatura */
	public List<ParcelaPagamentoFatura> listarParcelasPgtoFaturaPorCodFatura(String str) {
		return parcelasPagamentoFatura.listarParcelasPgtoPorCodFatura(str);
	}

}
