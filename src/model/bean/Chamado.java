package model.bean;

/**
 *
 * @author 
 */
public class Chamado {
	private Long sequencial;
	private String tipo;
	private String statusChamado;
	private String descricao;
	private String prioridade;
	private String matSupervisor;
	private String matTecInterno;
	private String matAtendente;
	private Long numOrdemServico;
	private Long codCliente;
	private Long idAtendimento;
	private String dataAbertura;
	

	public Chamado() {
		
	}
	
	public Chamado(Long sequencial, String tipo, String statusChamado, String descricao,
			String prioridade, String matSupervisor, String matTecInterno, String matAtendente, Long numOrdemServico,
			Long codCliente, Long idAtendimento, String dataAbertura) {
		super();
		this.sequencial = sequencial;
		this.tipo = tipo;
		this.statusChamado = statusChamado;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.matSupervisor = matSupervisor;
		this.matTecInterno = matTecInterno;
		this.matAtendente = matAtendente;
		this.numOrdemServico = numOrdemServico;
		this.codCliente = codCliente;
		this.idAtendimento = idAtendimento;
		this.dataAbertura = dataAbertura;
	}

	public Long getSequencial() {
		return sequencial;
	}

	public void setSequencial(Long sequencial) {
		this.sequencial = sequencial;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatusChamado() {
		return statusChamado;
	}

	public void setStatusChamado(String statusChamado) {
		this.statusChamado = statusChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getPrioridade(){
		return prioridade;
	}
	
	public void setPrioridade(String prioridade){
		this.prioridade = prioridade;
	}

	public String getMatSupervisor() {
		return matSupervisor;
	}

	public void setMatSupervisor(String matSupervisor) {
		this.matSupervisor = matSupervisor;
	}

	public String getMatTecInterno() {
		return matTecInterno;
	}

	public void setMatTecInterno(String matTecInterno) {
		this.matTecInterno = matTecInterno;
	}

	public String getMatAtendente() {
		return matAtendente;
	}

	public void setMatAtendente(String matAtendente) {
		this.matAtendente = matAtendente;
	}

	public Long getNumOrdemServico() {
		return this.numOrdemServico;
	}

	public void setNumOrdemServico(Long numOrdemServico) {
		this.numOrdemServico = numOrdemServico;
	}

	public Long getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
	}
	
	public Long getIdAtendimento() {
		return this.idAtendimento;
	}
	
	public void setIdAtendimento(Long idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public String getDataAbertura() {
		return this.dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@Override
	public String toString() {
		return "Chamado [sequencial=" + sequencial + ", tipo=" + tipo + ", statusChamado=" + statusChamado + ", descricao=" + descricao + ", prioridade="
				+ prioridade + ", matSupervisor=" + matSupervisor + ", matTecInterno=" + matTecInterno + ", matAtendente=" + matAtendente
				+ ", numOrdemServico=" + numOrdemServico + ", codCliente=" + codCliente + ", idAtendimento=" + idAtendimento
				+ ", dataAbertura=" + dataAbertura + "]";
	}

}
