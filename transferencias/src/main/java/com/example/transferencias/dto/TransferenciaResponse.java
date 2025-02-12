package com.example.transferencias.dto;

import com.example.transferencias.model.Transferencia;

public class TransferenciaResponse {

	private Long id;
	private String contaOrigem;
	private String contaDestino;
	private String valorBrutoFormatado;
	private String valorLiquidoFormatado;
	private String taxaFormatada;
	private String dataTransferenciaFormatada;
	private String dataAgendamentoFormatada;

	// Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public String getValorBrutoFormatado() {
		return valorBrutoFormatado;
	}

	public void setValorBrutoFormatado(String valorBrutoFormatado) {
		this.valorBrutoFormatado = valorBrutoFormatado;
	}

	public String getValorLiquidoFormatado() {
		return valorLiquidoFormatado;
	}

	public void setValorLiquidoFormatado(String valorLiquidoFormatado) {
		this.valorLiquidoFormatado = valorLiquidoFormatado;
	}

	public String getTaxaFormatada() {
		return taxaFormatada;
	}

	public void setTaxaFormatada(String taxaFormatada) {
		this.taxaFormatada = taxaFormatada;
	}

	public String getDataTransferenciaFormatada() {
		return dataTransferenciaFormatada;
	}

	public void setDataTransferenciaFormatada(String dataTransferenciaFormatada) {
		this.dataTransferenciaFormatada = dataTransferenciaFormatada;
	}

	public String getDataAgendamentoFormatada() {
		return dataAgendamentoFormatada;
	}

	public void setDataAgendamentoFormatada(String dataAgendamentoFormatada) {
		this.dataAgendamentoFormatada = dataAgendamentoFormatada;
	}

	// Método para converter Transferencia em TransferenciaResponse
	public static TransferenciaResponse fromTransferencia(Transferencia transferencia) {
		TransferenciaResponse response = new TransferenciaResponse();
		response.setId(transferencia.getId());
		response.setContaOrigem(transferencia.getContaOrigem());
		response.setContaDestino(transferencia.getContaDestino());
		response.setValorBrutoFormatado(transferencia.getValorBrutoFormatado());
		response.setValorLiquidoFormatado(transferencia.getValorLiquidoFormatado());
		response.setTaxaFormatada(transferencia.getTaxaFormatada());
		response.setDataTransferenciaFormatada(transferencia.getDataTransferenciaFormatada());
		response.setDataAgendamentoFormatada(transferencia.getDataAgendamentoFormatada());
		return response;
	}
}
