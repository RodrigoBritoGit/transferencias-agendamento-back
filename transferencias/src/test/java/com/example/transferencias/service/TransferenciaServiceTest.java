package com.example.transferencias.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransferenciaServiceTest {

	private TransferenciaService transferenciaService;

	@BeforeEach
	public void setUp() {
		// Instanciando o serviço antes de cada teste
		transferenciaService = new TransferenciaService();
	}

	@Test
	public void testCalcularTaxa_DiaMenorQueZero() {
		// Mockando a data atual
		LocalDate dataDeTransferencia = LocalDate.now().minusDays(2); // 2 dias atrás

		// Testando a regra de dias menores que 0
		double taxa = transferenciaService.calcularTaxa(dataDeTransferencia);
		assertEquals(0.025, taxa, "A taxa para datas com dias negativos deve ser 0.025");
	}

	@Test
	public void testCalcularTaxa_Entre1e10Dias() {
		// Mockando a data para 5 dias no futuro
		LocalDate dataDeTransferencia = LocalDate.now().plusDays(5); // 5 dias no futuro

		// Testando a taxa entre 1 e 10 dias
		double taxa = transferenciaService.calcularTaxa(dataDeTransferencia);
		assertEquals(0.0, taxa, "A taxa para transferências entre 1 e 10 dias deve ser 0.0");
	}

	@Test
	public void testCalcularTaxa_Entre11e20Dias() {
		// Mockando a data para 15 dias no futuro
		LocalDate dataDeTransferencia = LocalDate.now().plusDays(15); // 15 dias no futuro

		// Testando a taxa entre 11 e 20 dias
		double taxa = transferenciaService.calcularTaxa(dataDeTransferencia);
		assertEquals(0.082, taxa, "A taxa para transferências entre 11 e 20 dias deve ser 0.082");
	}

	@Test
	public void testCalcularTaxa_Entre21e30Dias() {
		// Mockando a data para 25 dias no futuro
		LocalDate dataDeTransferencia = LocalDate.now().plusDays(25); // 25 dias no futuro

		// Testando a taxa entre 21 e 30 dias
		double taxa = transferenciaService.calcularTaxa(dataDeTransferencia);
		assertEquals(0.069, taxa, "A taxa para transferências entre 21 e 30 dias deve ser 0.069");
	}

	@Test
	public void testCalcularTaxa_Entre31e40Dias() {
		// Mockando a data para 35 dias no futuro
		LocalDate dataDeTransferencia = LocalDate.now().plusDays(35); // 35 dias no futuro

		// Testando a taxa entre 31 e 40 dias
		double taxa = transferenciaService.calcularTaxa(dataDeTransferencia);
		assertEquals(0.047, taxa, "A taxa para transferências entre 31 e 40 dias deve ser 0.047");
	}

	@Test
	public void testCalcularTaxa_Entre41e50Dias() {
		// Mockando a data para 45 dias no futuro
		LocalDate dataDeTransferencia = LocalDate.now().plusDays(45); // 45 dias no futuro

		// Testando a taxa entre 41 e 50 dias
		double taxa = transferenciaService.calcularTaxa(dataDeTransferencia);
		assertEquals(0.017, taxa, "A taxa para transferências entre 41 e 50 dias deve ser 0.017");
	}

	@Test
	public void testCalcularTaxa_MaiorQue50Dias() {
		// Mockando a data para 55 dias no futuro
		LocalDate dataDeTransferencia = LocalDate.now().plusDays(55); // 55 dias no futuro

		// Testando a taxa para mais de 50 dias
		double taxa = transferenciaService.calcularTaxa(dataDeTransferencia);
		assertEquals(-1, taxa, "A taxa para transferências com mais de 50 dias deve ser -1");
	}
}
