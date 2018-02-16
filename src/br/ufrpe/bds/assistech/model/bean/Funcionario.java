package br.ufrpe.bds.assistech.model.bean;

import java.util.Date;

/**
 *
 * @author BARTOLOMEU.DIAS
 */
public class Funcionario {
	private String matFuncionario;
	private Long CPF;
	private String login;
	private String senha;
	private String Nome;
	private String email;
	private Integer cargaHoraria;
	private String matriculaSuperv;
	private String Id_jornada;
	private String data_inicio;
	private int codUnid_Suporte;
	

	public Funcionario() {
		
	}
	
	public Funcionario(String matFuncionario, String matriculaSuperv, String nome, Long CPF,
			int codUnid_Suporte, String login, String senha, String email, Integer cargaHoraria, Date data_inicio, String Id_jornada) {
		super();
		this.matFuncionario = matFuncionario;
		this.matriculaSuperv = matriculaSuperv;
		this.Nome = nome;
		this.CPF = CPF;
		this.codUnid_Suporte = codUnid_Suporte;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.cargaHoraria = cargaHoraria;
		this.Id_jornada = Id_jornada;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matFuncionario;
	}

	public void setMatricula(String matFuncionario) {
		this.matFuncionario = matFuncionario;
	}

	public String getMatriculaSuperv() {
		return matriculaSuperv;
	}

	public void setMatriculaSuperv(String matriculaSuperv) {
		this.matriculaSuperv = matriculaSuperv;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long CPF) {
		this.CPF = CPF;
	}

	public int getCodUnid_Suporte() {
		return this.codUnid_Suporte;
	}

	public void setCodUnid_Suporte(int codUnid_Suporte) {
		this.codUnid_Suporte = codUnid_Suporte;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getDataInicio() {
		return this.data_inicio;
	}
	

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getIdjornada() {
		return this.Id_jornada;
	}

	public void setId_jornada(String id_jornada) {
		this.Id_jornada = id_jornada;
	}

	@Override
	public String toString() {
		return "Funcionario [matFuncionario=" + matFuncionario + ", CPF=" + CPF + ", login=" + login + ", senha="
				+ senha + ", Nome=" + Nome + ", email=" + email + ", cargaHoraria=" + cargaHoraria
				+ ", matriculaSuperv=" + matriculaSuperv + ", Id_jornada=" + Id_jornada + ", data_inicio=" + data_inicio
				+ ", codUnid_Suporte=" + codUnid_Suporte + "]";
	}

}
