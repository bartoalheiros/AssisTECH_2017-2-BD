package br.ufrpe.assistec.service;

import java.util.List;

import br.ufrpe.assistec.exception.ClienteJahCadastradoException;
import br.ufrpe.assistec.model.Cliente;

public interface IRepositorioClientes {
	public boolean cadastra(Cliente cliente);
	
	public void atualiza(Cliente cli);

	public Cliente busca(Long cpf);


	void exclui(Long cpf);
	
	
}
