package br.ufrpe.assistec.model;

import java.math.BigInteger;

public class Fornecedor {
	private Long CNPJ;
	private String RazaoSocial;
	private String Email;
	private String Telefone;
	
	public Fornecedor() {}
	
	public Fornecedor(Long CNPJ, String razaoSocial, String email, String telefone) {
		this.CNPJ = CNPJ;
		this.RazaoSocial = razaoSocial;
		this.Email = email;
		this.Telefone = telefone;
	}

	public Long getCNPJ() {
		return this.CNPJ;
	}

	public void setCNPJ(Long CNPJ) {
		this.CNPJ = CNPJ;
	}

	public String getRazaoSocial() {
		return this.RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.RazaoSocial = razaoSocial;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getTelefone() {
		return this.Telefone;
	}

	public void setTelefone(String telefone) {
		this.Telefone = telefone;
	}

	@Override
	public String toString() {
		return "Fornecedor [CNPJ=" + CNPJ + ", RazaoSocial=" + RazaoSocial + ", Email=" + Email + ", Telefone="
				+ Telefone + "]";
	}
	
	
}
