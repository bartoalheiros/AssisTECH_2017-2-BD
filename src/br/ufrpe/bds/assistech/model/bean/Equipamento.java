package br.ufrpe.bds.assistech.model.bean;

public class Equipamento {
	private String cod;
	private String Dta_entrada;
	private String setor;
	private String historico;
	private String fabricante;
	private String estado;
	private String descricao;
	private String cod_contrato;
	private Long cnpj_unid_suporte;
	private Long cod_cliente;
	private String data_inicio;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getDta_entrada() {
		return Dta_entrada;
	}
	public void setDta_entrada(String dta_entrada) {
		Dta_entrada = dta_entrada;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCod_contrato() {
		return cod_contrato;
	}
	public void setCod_contrato(String cod_contrato) {
		this.cod_contrato = cod_contrato;
	}
	public Long getCnpj_unid_suporte() {
		return cnpj_unid_suporte;
	}
	public void setCnpj_unid_suporte(Long cnpj_unid_suporte) {
		this.cnpj_unid_suporte = cnpj_unid_suporte;
	}
	public Long getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(Long cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	
	
}
