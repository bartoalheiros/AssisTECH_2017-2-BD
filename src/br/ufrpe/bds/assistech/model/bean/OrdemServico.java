package br.ufrpe.bds.assistech.model.bean;

public class OrdemServico {
	private Long NumOS;
	private String DtDevida;
	private Long PrazoEmDias;
	private String DtCriacao;
	private String Status;
	private Long CodOrcamento;
	private Long CodFatura;
	
	public Long getNumOS() {
		return NumOS;
	}
	public void setNumOS(Long numOS) {
		NumOS = numOS;
	}
	public String getDtDevida() {
		return DtDevida;
	}
	public void setDtDevida(String dtDevida) {
		DtDevida = dtDevida;
	}
	public Long getPrazoEmDias() {
		return PrazoEmDias;
	}
	public void setPrazoEmDias(Long prazoEmDias) {
		PrazoEmDias = prazoEmDias;
	}
	public String getDtCriacao() {
		return DtCriacao;
	}
	public void setDtCriacao(String dtCriacao) {
		DtCriacao = dtCriacao;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Long getCodOrcamento() {
		return CodOrcamento;
	}
	public void setCodOrcamento(Long codOrcamento) {
		CodOrcamento = codOrcamento;
	}
	public Long getCodFatura() {
		return CodFatura;
	}
	public void setCodFatura(Long codFatura) {
		CodFatura = codFatura;
	}
	
	
}
