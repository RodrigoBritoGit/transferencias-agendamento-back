package com.example.transferencias.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataTransferencia;
	private Date dataAgendamento;

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

	public Date getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(Date dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(this.dataTransferencia);
	}

	public String getDataAgendamentoFormatada() {
		if (dataAgendamento == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(this.dataAgendamento);
	}
}
