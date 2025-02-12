package com.example.transferencias.controller;

import com.example.transferencias.dto.TransferenciaResponse;
import com.example.transferencias.model.Transferencia;
import com.example.transferencias.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferenciaService;

	@PostMapping
	public ResponseEntity<TransferenciaResponse> agendarTransferencia(@RequestBody Transferencia transferencia) {
		// Chama o serviço para agendar a transferência
		Transferencia transferenciaCriada = transferenciaService.agendarTransferencia(transferencia);

		// Verifica se a transferência foi criada corretamente
		if (transferenciaCriada == null) {
			return ResponseEntity.badRequest().body(null); // Retorna bad request caso haja erro
		}

		// Converte a Transferencia criada para TransferenciaResponse
		TransferenciaResponse response = TransferenciaResponse.fromTransferencia(transferenciaCriada);

		// Retorna a resposta com o TransferenciaResponse no corpo
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<List<TransferenciaResponse>> listarTransferencias() {
		// Obtém todas as transferências do serviço
		List<Transferencia> transferencias = transferenciaService.listarTransferencias();

		// Converte as transferências para TransferenciaResponse
		List<TransferenciaResponse> transferenciasResponse = transferencias.stream()
				.map(TransferenciaResponse::fromTransferencia).collect(Collectors.toList());

		// Retorna a lista de TransferenciaResponse
		return ResponseEntity.ok(transferenciasResponse);
	}
}
