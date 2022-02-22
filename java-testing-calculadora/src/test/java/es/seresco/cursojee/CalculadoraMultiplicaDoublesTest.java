package es.seresco.cursojee;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculadoraMultiplicaDoublesTest {

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
	public void testMultiplicaCeroPorCero() {
		// Given
		double num1 = 0;
		double num2 = 0;
		double expected = 0;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaPositivoPorCero() {
		// Given
		double num1 = Math.random() * 1000 + 1;
		double num2 = 0;
		double expected = 0;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaPositivoPorCeroComutativa() {
		// Given
		double num1 = Math.random() * 1000 + 1;
		double num2 = 0;
		double expected = 0;
		// do
		double result = calculadora.multiplicar(num2, num1);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaNegativoPorCero() {
		// Given
		double num1 = Math.random() * -1000 - 1;
		double num2 = 0;
		double expected = 0;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaNegativoPorCeroComutativa() {
		// Given
		double num1 = Math.random() * -1000 - 1;
		double num2 = 0;
		double expected = 0;
		// do
		double result = calculadora.multiplicar(num2, num1);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaLimitePositivoPorCero() {
		// Given
		double num1 = Double.MAX_VALUE;
		double num2 = 0;
		double expected = 0;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaLimiteNegativoPorCero() {
		// Given
		double num1 = Double.MIN_VALUE;
		double num2 = 0;
		double expected = 0;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testDoblaLimitePositivo() {
		// Given
		double num1 = Double.MAX_VALUE;
		double num2 = 2;
		double expected = Double.POSITIVE_INFINITY;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testDoblaLimiteNegativo() {
		// Given
		double num1 = Double.MAX_VALUE;
		double num2 = -2;
		double expected = Double.NEGATIVE_INFINITY;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaDosNumerosPositivosRandom() {
		// Given
		double num1 = Math.random() * 10000 + 0.01;
		double num2 = Math.random() * 10000 + 0.01;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertTrue(String.format("%s should be positive", result), result > 0);
	}

	@Test
	public void testMultiplicaDosNumerosPositivos() {
		// Given
		double num1 = 5;
		double num2 = 2;
		double expected = 10;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaDosNumerosPositivosComutativa() {
		// Given
		double num1 = 5;
		double num2 = 2;
		double expected = 10;
		// do
		double result = calculadora.multiplicar(num2, num1);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaDosNumerosNegativosRandom() {
		// Given
		double num1 = Math.random() * -10000 - 0.01;
		double num2 = Math.random() * -10000 - 0.01;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertTrue(String.format("%s should be positive", result), result > 0);
	}

	@Test
	public void testMultiplicaDosNumerosNegativos() {
		// Given
		double num1 = -5;
		double num2 = -2;
		double expected = 10;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaDosNumerosNegativosComutativa() {
		// Given
		double num1 = -5;
		double num2 = -2;
		double expected = 10;
		// do
		double result = calculadora.multiplicar(num2, num1);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaDosNumerosDistintoSignoRandom() {
		// Given
		double num1 = Math.random() * 10000 + 0.01;
		double num2 = Math.random() * -10000 - 0.01;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertTrue(String.format("%s should be negative", result), result < 0);
	}

	@Test
	public void testMultiplicaDosNumerosDistintoSigno() {
		// Given
		double num1 = -5;
		double num2 = 3;
		double expected = -15;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaDosNumerosDistintoSignoComutativa() {
		// Given
		double num1 = -5;
		double num2 = 3;
		double expected = -15;
		// do
		double result = calculadora.multiplicar(num2, num1);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

	@Test
	public void testMultiplicaDosNumerosDecimales() {
		// Given
		double num1 = 0.3;
		double num2 = 0.5;
		double expected = 0.15;
		// do
		double result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result, 0);
	}

}
