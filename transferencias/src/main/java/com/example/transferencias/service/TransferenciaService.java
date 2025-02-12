package com.example.transferencias.service;

import com.example.transferencias.model.Transferencia;
import com.example.transferencias.repository.TransferenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	public ResponseEntity<Transferencia> agendarTransferencia(Transferencia transferencia) {

		double taxa = calcularTaxa(transferencia.getDataTransferencia());

		if (taxa == -1) {
			return ResponseEntity.badRequest().body(null);
		}

		transferencia.setTaxa(taxa);

		double valorLiquido = transferencia.getValorBruto() - (transferencia.getValorBruto() * taxa);

		transferencia.setValorLiquido(valorLiquido);

		transferencia.setDataAgendamento(new Date());

		Transferencia transferenciaSalva = transferenciaRepository.save(transferencia);

		return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaSalva);
	}

	public double calcularTaxa(Date dataTransferencia) {

		long diasDeDiferenca = (dataTransferencia.getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);

		if (diasDeDiferenca < 0)
			return 0.025;
		if (diasDeDiferenca >= 1 && diasDeDiferenca <= 10)
			return 0.00;
		if (diasDeDiferenca >= 11 && diasDeDiferenca <= 20)
			return 0.082;
		if (diasDeDiferenca >= 21 && diasDeDiferenca <= 30)
			return 0.069;
		if (diasDeDiferenca >= 31 && diasDeDiferenca <= 40)
			return 0.047;
		if (diasDeDiferenca >= 41 && diasDeDiferenca <= 50)
			return 0.017;

		return -1;
	}

	public List<Transferencia> listarTransferencias() {
		return transferenciaRepository.findAll();
	}
}
