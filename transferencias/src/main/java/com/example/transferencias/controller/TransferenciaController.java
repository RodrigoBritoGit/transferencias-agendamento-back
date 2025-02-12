package com.example.transferencias.controller;

import com.example.transferencias.model.Transferencia;
import com.example.transferencias.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferenciaService;

	@PostMapping
	public ResponseEntity<Transferencia> agendarTransferencia(@RequestBody Transferencia transferencia) {
		return transferenciaService.agendarTransferencia(transferencia);
	}

	@GetMapping
	public List<Transferencia> listarTransferencias() {
		List<Transferencia> transferencias = transferenciaService.listarTransferencias();

		for (Transferencia transferencia : transferencias) {
			transferencia.getValorBrutoFormatado();
			transferencia.getValorLiquidoFormatado();
			transferencia.getTaxaFormatada();
			transferencia.getDataTransferenciaFormatada();
			transferencia.getDataAgendamentoFormatada();
		}

		return transferencias;
	}
}
