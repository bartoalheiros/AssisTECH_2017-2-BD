package br.ufrpe.assistec.model;

public class Fornecedor {
	private Long CNPJ;
	private String RazaoSocial;
	private String Email;
	private String Telefone;
	
	public Fornecedor() {}
	
	public Fornecedor(Long cNPJ, String razaoSocial, String email, String telefone) {
		CNPJ = cNPJ;
		RazaoSocial = razaoSocial;
		Email = email;
		Telefone = telefone;
	}

	public Long getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(Long cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	@Override
	public String toString() {
		return "Fornecedor [CNPJ=" + CNPJ + ", RazaoSocial=" + RazaoSocial + ", Email=" + Email + ", Telefone="
				+ Telefone + "]";
	}
	
	
}
