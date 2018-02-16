package br.ufrpe.bds.assistech.model.bean;

public class Fornecedor {
private Long cnpj;
private String razaoSocial;
private String email;
private String telefone;

public Long getCnpj(){
	return cnpj;
}
public void setCnpj(Long cnpj){
	this.cnpj = cnpj;
}
public String getRazaoSocial(){
	return razaoSocial;
}
public void setRazaoSocial(String razaoSocial){
	this.razaoSocial = razaoSocial;
}
public String getEmail(){
	return email;
}
public void setEmail(String email){
	this.email = email;
}
public String getTelefone(){
	return telefone;
}
public void setTelefone(String telefone){
	this.telefone = telefone;
}
}
