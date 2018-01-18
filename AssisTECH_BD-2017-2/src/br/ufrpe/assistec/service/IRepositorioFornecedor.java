package br.ufrpe.assistec.service;

import java.sql.Connection;
import java.util.List;

import br.ufrpe.assistec.model.Fornecedor;

public interface IRepositorioFornecedor {
	List<Fornecedor> lista_Fornecedor(Connection connection);
}
