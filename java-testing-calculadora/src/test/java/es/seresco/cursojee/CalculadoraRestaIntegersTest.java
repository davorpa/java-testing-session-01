package es.seresco.cursojee;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculadoraRestaIntegersTest {

	private Calculadora calculadora;

	/**
	 * Antes de lanzar cada test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	/**
	 * Despues de lanzar cada test
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		calculadora = null;
	}

	@Test
	public void testRestaPositivosIguales() {
		// Given
		int num1 = 5;
		int num2 = 5;
		int expected = 0;
		// do
		int result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testRestaPositivosMayorMinuendoQueSustraendo() {
		// Given
		int num1 = 15;
		int num2 = 5;
		int expected = 10;
		// do
		int result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testRestaPositivosMenorMinuendoQueSustraendo() {
		// Given
		int num1 = 10;
		int num2 = 15;
		int expected = -5;
		// do
		int result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testRestaNegativosIguales() {
		// Given
		int num1 = -5;
		int num2 = -5;
		int expected = 0;
		// do
		int result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testRestaNegativosMayorMinuendoQueSustraendo() {
		// Given
		int num1 = -5;
		int num2 = -15;
		int expected = 10;
		// do
		int result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testRestaNegativosMenorMinuendoQueSustraendo() {
		// Given
		int num1 = -15;
		int num2 = -10;
		int expected = -5;
		// do
		int result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

}
