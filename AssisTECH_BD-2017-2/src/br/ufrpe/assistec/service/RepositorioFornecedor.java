package br.ufrpe.assistec.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.assistec.model.Fornecedor;
import br.ufrpe.assistec.model.Funcionario;

public class RepositorioFornecedor implements IRepositorioFornecedor {

	@Override
	public List<Fornecedor> lista_Fornecedor(Connection connection) {
		List<Fornecedor> listaFornecedor = new ArrayList<>();

		String sql = "select * from fornecedor";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			Funcionario f = new Funcionario();
			
			while (resultset.next()) {
				
				f.setMatricula(resultset.getString("Matricula"));
				f.setMatriculaSuperv(resultset.getString("MatriculaSupervisor"));
				f.setNome(resultset.getString("Nome"));
				f.setCPF(resultset.getLong("CPF"));
				f.setCodUnid_Suporte(resultset.getInt("Cod_Unid_Suporte"));
				f.setLogin(resultset.getString("Login"));
				f.setSenha(resultset.getString("Senha"));
				f.setEmail(resultset.getString("Email"));
				f.setCargaHoraria(resultset.getInt("Carga_hora"));

				listaFornecedor.add(f);

			}
			resultset.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//System.out.println(listaFuncionario);
		
		return listaFornecedor;
	}

}
