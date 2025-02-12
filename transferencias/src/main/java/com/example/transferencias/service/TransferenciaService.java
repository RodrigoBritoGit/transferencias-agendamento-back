package com.example.transferencias.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transferencias.model.Transferencia;
import com.example.transferencias.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	// Alterando para retornar apenas Transferencia
	public Transferencia agendarTransferencia(Transferencia transferencia) {

		double taxa = calcularTaxa(transferencia.getDataTransferencia());

		if (taxa == -1) {
			return null; // Retorna null caso a taxa seja inválida
		}

		transferencia.setTaxa(taxa);

		double valorLiquido = transferencia.getValorBruto() - (transferencia.getValorBruto() * taxa);
		transferencia.setValorLiquido(valorLiquido);

		// Usando LocalDate para a data de agendamento
		transferencia.setDataAgendamento(LocalDate.now());

		// Salva a transferência no repositório e retorna o objeto Transferencia
		return transferenciaRepository.save(transferencia);
	}

	// Método para calcular a taxa com base na data de transferência
	public double calcularTaxa(LocalDate dataTransferencia) {
		// Calculando a diferença em dias entre a data de transferência e a data atual
		long diasDeDiferenca = ChronoUnit.DAYS.between(LocalDate.now(), dataTransferencia);

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

	// Método para listar todas as transferências
	public List<Transferencia> listarTransferencias() {
		return transferenciaRepository.listarTransferencias();
	}
}
