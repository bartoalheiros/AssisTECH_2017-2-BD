package br.ufrpe.assistec.control;
/*Fachada: serve para as classes de UI do sistema terem acesso a todas as funcionalidades do mesmo.*/

import java.util.List;

import br.ufrpe.assistec.exception.ClienteJahCadastradoException;
import br.ufrpe.assistec.exception.ClienteNaoCadastradoException;
import br.ufrpe.assistec.exception.NomeDeUsuarioOuSenhaInvalidaException;

import br.ufrpe.assistec.model.Cliente;


public class ServidorAssisTech {
	private ControladorClientes clientes;
	

	private static ServidorAssisTech instance;

	private ServidorAssisTech() {
		this.clientes = new ControladorClientes();
		
	}


	/**
	 * Implementando padr�o Singleton
	 * 
	 * @return A inst�ncia da desta fachada
	 */
	public static ServidorAssisTech getInstance() {
		if(instance == null) {
			instance = new ServidorAssisTech();
		}

		return instance;
	}

	public void cadastrarCliente(Cliente c) throws ClienteJahCadastradoException { 
		clientes.cadastrar(c);
	}

	public Cliente buscarCliente(Long cpf) throws ClienteNaoCadastradoException {
		return clientes.buscar(cpf);
	}
	
	public void buscarClientePorLogin(String usrName, String passwd) throws NomeDeUsuarioOuSenhaInvalidaException {
		clientes.buscarPorLogin(usrName, passwd);
	} 

	public void removerCliente(Long cpf) { 
		clientes.remover(cpf);
	}

	public void atualizar (Cliente c) { 
		clientes.atualizar(c);
	}

	public List<Cliente> listarClientes() {
		return clientes.listar();
	}
	
	


	public void autenticaFuncionario(String usrName, String pswd) {
		//funcionarios.autenticaFuncionario()
		
	}
	
	

}
