package br.ufrpe.bds.assistech.model.bean;

public class ParcelaPagamentoFatura {
	private Long seqParcelaPgto;
	private Long codFatura;
	private String dtaPagto;
	private String dtaParcela;
	private float juros;
	private float valorTotal;
	private float valorPgtoParcela;
	public Long getSeqParcelaPgto() {
		return seqParcelaPgto;
	}
	public void setSeqParcelaPgto(Long seqParcelaPgto) {
		this.seqParcelaPgto = seqParcelaPgto;
	}
	public Long getCodFatura() {
		return codFatura;
	}
	public void setCodFatura(Long codFatura) {
		this.codFatura = codFatura;
	}
	public String getDtaPagto() {
		return dtaPagto;
	}
	public void setDtaPagto(String dtaPagto) {
		this.dtaPagto = dtaPagto;
	}
	public String getDtaParcela() {
		return dtaParcela;
	}
	public void setDtaParcela(String dtaParcela) {
		this.dtaParcela = dtaParcela;
	}
	public float getJuros() {
		return juros;
	}
	public void setJuros(float juros) {
		this.juros = juros;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public float getValorPgtoParcela() {
		return valorPgtoParcela;
	}
	public void setValorPgtoParcela(float valorPgtoParcela) {
		this.valorPgtoParcela = valorPgtoParcela;
	}
	
	
}
