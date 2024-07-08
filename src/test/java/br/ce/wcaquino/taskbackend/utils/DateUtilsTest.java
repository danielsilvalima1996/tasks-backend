package br.ce.wcaquino.taskbackend.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void deveRetornarTrueParaDatasFuturas() {
		LocalDate date = LocalDate.of(2030, 01, 01);
		boolean retorno = DateUtils.isEqualOrFutureDate(date);
		assertTrue(retorno);
	}
	
	@Test
	public void deveRetornarFalseParaDatasPassadas() {
		LocalDate date = LocalDate.of(2010, 01, 01);
		boolean retorno = DateUtils.isEqualOrFutureDate(date);
		assertFalse(retorno);
	}
	
	@Test
	public void deveRetornarFalseParaDatasFuturas() {
		LocalDate date = LocalDate.now();
		boolean retorno = DateUtils.isEqualOrFutureDate(date);
		assertTrue(retorno);
	}

}
