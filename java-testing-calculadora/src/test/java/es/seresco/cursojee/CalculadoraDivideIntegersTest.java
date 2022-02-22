package es.seresco.cursojee;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculadoraDivideIntegersTest {

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

	@Test(expected = DivisionByZeroArithmeticException.class)
	public void testDividePositivoPorCero() {
		// Given
		int num1 = (int) (Math.random() * 1000);
		int num2 = 0;
		// do
		calculadora.dividir(num1, num2);
	}
	
	@Test(expected = DivisionByZeroArithmeticException.class)
	public void testDivideNegativoPorCero() {
		// Given
		int num1 = (int) (Math.random() * -1000);
		int num2 = 0;
		// do
		calculadora.dividir(num1, num2);
	}

	@Test(expected = DivisionByZeroArithmeticException.class)
	public void testDivideCeroPorCero() {
		// Given
		int num1 = 0;
		int num2 = 0;
		// do
		calculadora.dividir(num1, num2);
	}

	@Test
	public void testDivideCeroPorPositivo() {
		// Given
		int num1 = 0;
		int num2 = (int) (Math.random() * 1000) + 1;
		int expected = 0;
		// do
		int result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testDivideCeroPorNegativo() {
		// Given
		int num1 = 0;
		int num2 = (int) (Math.random() * -1000) - 1;
		int expected = 0;
		// do
		int result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testDividePositivoPorPositivo() {
		// Given
		int num1 = 5;
		int num2 = 2;
		int expected = 2;
		// do
		int result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testDividePositivoPorNegativo() {
		// Given
		int num1 = 5;
		int num2 = -2;
		int expected = -2;
		// do
		int result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testDivideNegativoPorPositivo() {
		// Given
		int num1 = -5;
		int num2 = 3;
		int expected = -1;
		// do
		int result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testDividePositivoPorPositivoRandomExpectPositivo() {
		// Given
		int num1 = (int) (Math.random() * 1000) + 1;
		int num2 = (int) (Math.random() * 1000) + 1;
		// do
		int result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertTrue(String.format("%s should be positive", result), result >= 0);
	}

	@Test
	public void testDivideNegativoPorPositivoRandomExpectNegativo() {
		// Given
		int num1 = (int) (Math.random() * -1000) - 1;
		int num2 = (int) (Math.random() * 1000) + 1;
		// do
		int result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertTrue(String.format("%s should be negative", result), result <= 0);
	}

}
