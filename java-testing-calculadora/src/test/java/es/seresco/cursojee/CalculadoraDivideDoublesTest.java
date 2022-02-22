package es.seresco.cursojee;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculadoraDivideDoublesTest {

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
		double num1 = (Math.random() * 1000);
		double num2 = 0;
		// do
		calculadora.dividir(num1, num2);
	}
	
	@Test(expected = DivisionByZeroArithmeticException.class)
	public void testDivideNegativoPorCero() {
		// Given
		double num1 = (int) (Math.random() * -1000);
		double num2 = 0;
		// do
		calculadora.dividir(num1, num2);
	}

	@Test(expected = DivisionByZeroArithmeticException.class)
	public void testDivideCeroPorCero() {
		// Given
		double num1 = 0;
		double num2 = 0;
		// do
		calculadora.dividir(num1, num2);
	}

	@Test
	public void testDivideCeroPorPositivo() {
		// Given
		double num1 = 0;
		double num2 = (double) (Math.random() * 1000) + 0.01;
		double expected = 0;
		// do
		double result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testDivideCeroPorNegativo() {
		// Given
		double num1 = 0;
		double num2 = (int) (Math.random() * -1000) - 0.01;
		double expected = 0;
		// do
		double result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testDividePositivoPorPositivo() {
		// Given
		double num1 = 5;
		double num2 = 2;
		double expected = 2.5;
		// do
		double result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0.01);
	}

	@Test
	public void testDividePositivoPorNegativo() {
		// Given
		double num1 = 5;
		double num2 = -2;
		double expected = -2.5;
		// do
		double result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0.01);
	}

	@Test
	public void testDivideNegativoPorPositivo() {
		// Given
		double num1 = -5;
		double num2 = 3;
		double expected = -1.66;
		// do
		double result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0.01);
	}

	@Test
	public void testDividePositivoPorPositivoRandomExpectPositivo() {
		// Given
		double num1 = (Math.random() * 1000) + 0.01;
		double num2 = (Math.random() * 1000) + 0.01;
		// do
		double result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertTrue(String.format("%s should be positive", result), result > 0);
	}

	@Test
	public void testDivideNegativoPorPositivoRandomExpectNegativo() {
		// Given
		double num1 = (Math.random() * -1000) - 0.01;
		double num2 = (Math.random() * 1000) + 0.01;
		// do
		double result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertTrue(String.format("%s should be negative", result), result < 0);
	}

	@Test
	public void testDividePositivoPorNegativoRandomExpectNegativo() {
		// Given
		double num1 = (Math.random() * 1000) + 0.01;
		double num2 = (Math.random() * -1000) - 0.01;
		// do
		double result = calculadora.dividir(num1, num2);
		// assert expected
		Assert.assertTrue(String.format("%s should be negative", result), result < 0);
	}

}
