package es.seresco.cursojee;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculadoraRestaDoublesTest {

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
		double num1 = 5;
		double num2 = 5;
		double expected = 0;
		// do
		double result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testRestaPositivosMayorMinuendoQueSustraendo() {
		// Given
		double num1 = 15;
		double num2 = 5;
		double expected = 10;
		// do
		double result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testRestaPositivosMenorMinuendoQueSustraendo() {
		// Given
		double num1 = 10;
		double num2 = 15;
		double expected = -5;
		// do
		double result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testRestaNegativosIguales() {
		// Given
		double num1 = -5;
		double num2 = -5;
		double expected = 0;
		// do
		double result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testRestaNegativosMayorMinuendoQueSustraendo() {
		// Given
		double num1 = -5;
		double num2 = -15;
		double expected = 10;
		// do
		double result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testRestaNegativosMenorMinuendoQueSustraendo() {
		// Given
		double num1 = -15;
		double num2 = -10;
		double expected = -5;
		// do
		double result = calculadora.restar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

}
