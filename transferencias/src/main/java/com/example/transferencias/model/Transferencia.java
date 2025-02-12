package com.example.transferencias.model;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String contaOrigem;
	private String contaDestino;
	private Double valorBruto;
	private Double valorLiquido;
	private Double taxa;
	private LocalDate dataTransferencia;
	private LocalDate dataAgendamento;

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

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
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

	public String getValorBrutoFormatado() {
		if (valorBruto == null) {
			return "R$ 0.00";
		}
		DecimalFormat df = new DecimalFormat("R$ #,##0.00");
		return df.format(this.valorBruto);
	}

	public String getValorLiquidoFormatado() {
		if (valorLiquido == null) {
			return "R$ 0.00";
		}
		DecimalFormat df = new DecimalFormat("R$ #,##0.00");
		return df.format(this.valorLiquido);
	}

	public String getTaxaFormatada() {
		if (taxa == null) {
			return "0.0";
		}
		DecimalFormat df = new DecimalFormat("#0.0");
		return df.format(this.taxa * 100);
	}

	public String getDataTransferenciaFormatada() {
		if (dataTransferencia == null) {
			return "";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.dataTransferencia.format(formatter);
	}

	public String getDataAgendamentoFormatada() {
		if (dataAgendamento == null) {
			return "";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.dataAgendamento.format(formatter);
	}
}
