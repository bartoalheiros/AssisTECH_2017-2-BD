package br.ufrpe.assistec.control;

import java.util.List;

import br.ufrpe.assistec.exception.ClienteJahCadastradoException;
import br.ufrpe.assistec.exception.ClienteNaoCadastradoException;
import br.ufrpe.assistec.exception.NomeDeUsuarioOuSenhaInvalidaException;
import br.ufrpe.assistec.model.Cliente;
import br.ufrpe.assistec.service.IRepositorioClientes;
import br.ufrpe.assistec.service.RepositorioClientesArrayList;

public class ControladorClientes {
	private IRepositorioClientes repositorio;

	public ControladorClientes() {
		this.repositorio = RepositorioClientesArrayList.getInstance();
	}

	public boolean existe(Cliente c) {
		boolean resultado = ((RepositorioClientesArrayList)this.repositorio).existe(c);

		return resultado;
	}

	public void cadastrar(Cliente cliente) throws ClienteJahCadastradoException {

		if (this.existe(cliente)) {
			throw new ClienteJahCadastradoException(cliente.getCpf());
		}
		
		this.repositorio.cadastra(cliente);
		
		
//		boolean r = this.repositorio.cadastrar(cliente);
//
//		if (cliente != null) {
//			if(r == false) {
//				String cpf = cliente.getCpf();
//				throw new ClienteJahCadastradoException(cpf);
//			} 
//		}else {
//			throw new IllegalArgumentException("Par�metro inv�lido");
//		}

	}

	public Cliente buscar(Long cpf) throws ClienteNaoCadastradoException {
		Cliente cli = ((RepositorioClientesArrayList)this.repositorio).busca(cpf);

		if(cli == null) {
			throw new ClienteNaoCadastradoException(cpf);
		}

		return cli;
	}

	public void buscarPorLogin(String usrName, String passwd) throws NomeDeUsuarioOuSenhaInvalidaException {
		boolean resultado =  ((RepositorioClientesArrayList)this.repositorio).buscarPorLogin(usrName, passwd);

		if(resultado == false) {
			throw new NomeDeUsuarioOuSenhaInvalidaException();
		}	

	}

	public void atualizar (Cliente c) {
		if(this.existe(c)){
			((RepositorioClientesArrayList)this.repositorio).atualiza(c);
		}
	}

	public void remover(Long cpf) {
		
		((RepositorioClientesArrayList)this.repositorio).exclui(cpf);
		
	}

	public List<Cliente> listar() { 
		return ((RepositorioClientesArrayList)this.repositorio).listarTodos();
	}


}
