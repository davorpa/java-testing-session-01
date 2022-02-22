package es.seresco.cursojee;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculadoraMultiplicaIntegersTest {

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
	public void testMultiplicaPositivoPorCero() {
		// Given
		int num1 = 5;
		int num2 = 0;
		int expected = 0;
		// do
		int result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testMultiplicaPositivoPorCeroComutativa() {
		// Given
		int num1 = 5;
		int num2 = 0;
		int expected = 0;
		// do
		int result = calculadora.multiplicar(num2, num1);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testMultiplicaLimitePositivoPorCero() {
		// Given
		int num1 = Integer.MAX_VALUE;
		int num2 = 0;
		int expected = 0;
		// do
		int result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testMultiplicaLimiteNegativoPorCero() {
		// Given
		int num1 = Integer.MIN_VALUE;
		int num2 = 0;
		int expected = 0;
		// do
		int result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testDoblaLimitePositivo() {
		// Given
		int num1 = Integer.MAX_VALUE;
		int num2 = 2;
		int expected = -2;
		// do
		int result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testDoblaLimiteNegativo() {
		// Given
		int num1 = Integer.MAX_VALUE;
		int num2 = -2;
		int expected = 2;
		// do
		int result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testMultiplicaDosNumerosPositivos() {
		// Given
		int num1 = 5;
		int num2 = 2;
		int expected = 10;
		// do
		int result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testMultiplicaDosNumerosPositivosComutativa() {
		// Given
		int num1 = 5;
		int num2 = 2;
		int expected = 10;
		// do
		int result = calculadora.multiplicar(num2, num1);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testMultiplicaDosNumerosNegativos() {
		// Given
		int num1 = -5;
		int num2 = -2;
		int expected = 10;
		// do
		int result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testMultiplicaDosNumerosNegativosComutativa() {
		// Given
		int num1 = -5;
		int num2 = -2;
		int expected = 10;
		// do
		int result = calculadora.multiplicar(num2, num1);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testMultiplicaDosNumerosDistintoSigno() {
		// Given
		int num1 = -5;
		int num2 = 3;
		int expected = -15;
		// do
		int result = calculadora.multiplicar(num1, num2);
		// assert expected
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testMultiplicaDosNumerosDistintoSignoComutativa() {
		// Given
		int num1 = -5;
		int num2 = 3;
		int expected = -15;
		// do
		int result = calculadora.multiplicar(num2, num1);
		// assert expected
		Assert.assertEquals(expected, result);
	}

}
