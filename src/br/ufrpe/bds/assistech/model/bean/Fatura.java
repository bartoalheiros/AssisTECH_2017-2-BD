package br.ufrpe.bds.assistech.model.bean;

public class Fatura {
	private Long Cod;
	private Long Num_parcelas;
	private float Valor_total;
	private String Status;
	private Long Cod_cliente;
	
	public Long getCod() {
		return Cod;
	}
	public void setCod(Long cod) {
		Cod = cod;
	}
	public Long getNum_parcelas() {
		return Num_parcelas;
	}
	public void setNum_parcelas(Long num_parcelas) {
		Num_parcelas = num_parcelas;
	}
	public float getValor_total() {
		return Valor_total;
	}
	public void setValor_total(float valor_total) {
		Valor_total = valor_total;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Long getCod_cliente() {
		return Cod_cliente;
	}
	public void setCod_cliente(Long cod_cliente) {
		Cod_cliente = cod_cliente;
	}
	
	public String toString() {
		return Long.toString(getCod()); 
	}
	
}
