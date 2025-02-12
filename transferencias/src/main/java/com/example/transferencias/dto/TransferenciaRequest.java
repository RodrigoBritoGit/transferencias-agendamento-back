package com.example.transferencias.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

public class TransferenciaRequest {

	@Schema(description = "Número da conta de origem", example = "123")
	private String contaOrigem;

	@Schema(description = "Número da conta de destino", example = "456")
	private String contaDestino;

	@Schema(description = "Valor bruto da transferência", example = "100.00")
	private Double valorBruto;

	@Schema(description = "Data da transferência", example = "2025-02-11")
	private LocalDate dataTransferencia;

	@Schema(description = "Data de agendamento", example = "2025-02-10")
	private LocalDate dataAgendamento;

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

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
}
