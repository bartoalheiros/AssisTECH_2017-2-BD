/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.assistec.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ufrpe.assistec.model.Funcionario;

/**
 *
 * @author BARTOLOMEU.DIAS
 */
public class RepositorioFuncionarios implements IRepositorioFuncionarios{
	Connection connection = ConnectionFactory.getConexaoMySQL();
	
	private static IRepositorioFuncionarios instance = null;

	public static IRepositorioFuncionarios getInstance() {
		if(instance == null) {
			instance = new RepositorioFuncionarios();
		}

		return instance;
	}

	@Override
	public boolean cadastra(Funcionario f) {
		String sql = "insert into funcionario " +
				"(Matricula, CPF, Login, Senha, Nome, Email, Carga_hora, Matricula_supervisor, data_inicio, Cod_Unid_Suporte) " +
				"values (?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, f.getMatricula());
			statement.setLong(2, f.getCPF());
			statement.setString(3, f.getLogin());
			statement.setString(4, f.getSenha());
			statement.setString(5, f.getNome());
			statement.setString(6, f.getEmail());
			statement.setInt(7, f.getCargaHoraria());
			statement.setString(8, f.getMatriculaSuperv());
			statement.setDate(9, (Date) f.getDataInicio());
			statement.setInt(10, f.getCodUnid_Suporte());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

		return true;
	}
	
	//lista os funcionários na tabela
	public List<Funcionario> busca(String nomefuncionario) {

		List<Funcionario> listaFuncionario = new ArrayList<>();

		String sql = "select * from funcionario where Nome like'%" +nomefuncionario+"%'";

		//String sql = "select * from funcionario where Nome l" +nomefuncionario;

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			Funcionario f = new Funcionario();
			
			while (resultset.next()) {
				
				f.setMatricula(resultset.getString("Matricula"));
				f.setMatriculaSuperv(resultset.getString("MatriculaSupervisor"));
				f.setNome(resultset.getString("Nome"));
				f.setCPF(resultset.getLong("CPF"));
				f.setCodUnid_Suporte(resultset.getInt("CodigoUnidadeDeSuporte"));
				f.setLogin(resultset.getString("Login"));
				f.setSenha(resultset.getString("Senha"));
				f.setEmail(resultset.getString("Email"));
				f.setCargaHoraria(resultset.getInt("CargaHoraria"));

				listaFuncionario.add(f);

			}
			resultset.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//System.out.println(listaFuncionario);
		
		return listaFuncionario;
	}
	
	
	public List<Funcionario> lista() {
				
		List<Funcionario> employeeList = new ArrayList<>();

		String q = "select * from funcionario";

		try {
			PreparedStatement statement = connection.prepareStatement(q);
			
			ResultSet resultset = statement.executeQuery(q);
			Funcionario f = null;
			
			while (resultset.next()) {
				
				f = new Funcionario();
				
				f.setMatricula(resultset.getString("Matricula"));
				f.setCPF(resultset.getLong("CPF"));
				f.setLogin(resultset.getString("Login"));
				f.setSenha(resultset.getString("Senha"));
				f.setNome(resultset.getString("Nome"));
				f.setEmail(resultset.getString("Email"));
				f.setCargaHoraria(resultset.getInt("CargaHoraria"));
				f.setMatriculaSuperv(resultset.getString("MatriculaSupervisor"));
				//System.out.println(resultset.getString("MatriculaSupervisor"));
				//System.out.println( f.getMatriculaSuperv());
				f.setId_jornada(resultset.getString("IdJornada"));
				f.setData_inicio(resultset.getDate("DataInicio"));
				f.setCodUnid_Suporte(resultset.getInt("CodigoUnidadeDeSuporte"));
				

				employeeList.add(f);

			}
			resultset.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return employeeList;
	}
	

	@Override
	public void atualiza(Funcionario f) throws SQLException {
		String Matricula = f.getMatricula();
		String Matricula_Supervisor = f.getMatriculaSuperv();
		String Email = f.getEmail();
		String Nome = f.getNome();
        int Cod_Unid_Suporte = f.getCodUnid_Suporte();
        Long CPF = f.getCPF();
        String Login = f.getLogin();
		String Senha = f.getSenha();
		Integer Carga_hora = f.getCargaHoraria();
		String Carga_hora_Str = Carga_hora.toString();
        
		String sql = "UPDATE funcionario where Matricula like '%" +f.getMatricula()+"%' SET Matricula = '" + Matricula + 
				"%', Matricula_supervisor= '%" + Matricula_Supervisor + "%', Nome = '%" + Nome + "%', CPF = " + CPF + 
				"Cod_Unid_Suporte = '" + Cod_Unid_Suporte + "'Login = '"+ Login + 
				"'Senha = '" + Senha + "'Email = '" + Email + "'Carga_hora = " + Carga_hora_Str;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute(sql);
		
		
	}


}	




