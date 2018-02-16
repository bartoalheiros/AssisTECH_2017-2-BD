package br.ufrpe.bds.assistech.model.bean;

public class Computador {

	private String codEquipamento;
	private String sistemaOperacional;
	private String enderecoIp;
	private String fabricanteBios;
	private String versaoBios;
	private String tipo;
	
	public Computador(){
		
	}
	public Computador(String codEquipamento, String sistemaOperacional, 
			String enderecoIp, String fabricanteBios, String versaoBios, String tipo){
		super();
		this.codEquipamento = codEquipamento;
		this.sistemaOperacional = sistemaOperacional;
		this.enderecoIp = enderecoIp;
		this.fabricanteBios = fabricanteBios;
		this.versaoBios = versaoBios;
		this.tipo = tipo;
	}
	public String getCodEquipamento() {
		return codEquipamento;
	}
	public void setCodEquipamento(String codEquipamento) {
		this.codEquipamento = codEquipamento;
	}
	public String getSistemaOperacional() {
		return sistemaOperacional;
	}
	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
	public String getEnderecoIp() {
		return enderecoIp;
	}
	public void setEnderecoIp(String enderecoIp) {
		this.enderecoIp = enderecoIp;
	}
	public String getFabricanteBios() {
		return fabricanteBios;
	}
	public void setFabricanteBios(String fabricanteBios) {
		this.fabricanteBios = fabricanteBios;
	}
	public String getVersaoBios() {
		return versaoBios;
	}
	public void setVersaoBios(String versaoBios) {
		this.versaoBios = versaoBios;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Computador [codEquipamento=" + codEquipamento + ", sistemaOperacional=" + sistemaOperacional + ", enderecoIp=" + enderecoIp + ", fabricanteBios="
				+ fabricanteBios + ", versaoBios=" + versaoBios + ", tipo=" + tipo + "]";
	}

}
