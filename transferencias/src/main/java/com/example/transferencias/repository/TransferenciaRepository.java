package com.example.transferencias.repository;

import com.example.transferencias.model.Transferencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	@Query(value = "SELECT id, conta_origem, " + "conta_destino, valor_bruto,"
			+ " valor_liquido, taxa, data_transferencia, " + "data_agendamento "
			+ "FROM transferencia", nativeQuery = true)
	List<Transferencia> listarTransferencias();
}