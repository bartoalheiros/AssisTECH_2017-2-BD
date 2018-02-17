package br.ufrpe.bds.assistech.model.bean;

public class Componente {
private Long cod;
private String tipo;
private String modelo;
private String fabricante;
private String numeroSerie;
private String onboard;
public Long getCod() {
	return cod;
}
public void setCod(Long cod) {
	this.cod = cod;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getFabricante() {
	return fabricante;
}
public void setFabricante(String fabricante) {
	this.fabricante = fabricante;
}
public String getNumeroSerie() {
	return numeroSerie;
}
public void setNumeroSerie(String numeroSerie) {
	this.numeroSerie = numeroSerie;
}
public String getOnboard() {
	return onboard;
}
public void setOnboard(String onboard) {
	this.onboard = onboard;
}
}
