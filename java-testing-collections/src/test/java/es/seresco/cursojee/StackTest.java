package es.seresco.cursojee;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

	private final Integer[] CARTAS = new Integer[] {
			11, // AS
			0,
			10, // TRES
			0, 0, 0, 0, 0, 0, 
			1, // SOTA
			2, // CABALLO
			3  // REY
	};

	private final Supplier<Integer> cartaRandSupplier = () -> CARTAS[(int) (Math.random() * CARTAS.length)];

	private Stack<Integer> stackConElementos;
	private Stack<Integer> stackSinElementos;
	private Stack<Integer> stackConLimite;

	/**
	 * Antes de lanzar los tests, se crean dos pilas, una con elementos y otra sin
	 * ellos.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		stackConElementos = new Stack<>(0, 0, 2, 3, 4, 3, 11, 10, 11);
		stackSinElementos = new Stack<>();
		stackConLimite = new Stack<>(40);
	}

	/**
	 * Se verifica que la pila sin elementos devuelve <code>true</code> y
	 * <code>false</code> para la pila con elementos.
	 */
	@Test
	public void testStackVacio() {
		Assert.assertTrue("Stack without items should be empty",  stackSinElementos.isEmpty());
		Assert.assertTrue("Stack with items should be non empty", !stackConElementos.isEmpty());
	}

	/**
	 * Se añade un elemento a la pila y se verifica que existen dos elementos en la
	 * misma.
	 */
	@Test
	public void testApilar() {
		// given test table
		for (Stack<Integer> stack : List.of(stackSinElementos, stackConElementos)) {
			for (int i = 0; i <= (int) (Math.random() * 100); i++) {
				long size = stack.size();

				// do
				stack.apilar(cartaRandSupplier.get());
				long sizeCurrent = stack.size();

				// assert expectation
				Assert.assertEquals(String.format("Index=%s; `Stack.apilar` should increment size.", i),
					size + 1, sizeCurrent);
			}
		}
	}

	/**
	 * Se añade un elemento a la pila con un limite máximo y se verifica que no
	 * permite realizar la operacion.
	 */
	@Test
	public void testApilarWithMaxLimit() {
		// given
		for (int i = 0; !stackConLimite.isFull(); i++) {
			long size = stackConLimite.size();

			// do
			stackConLimite.apilar(cartaRandSupplier.get());
			long sizeCurrent = stackConLimite.size();

			// assert expectation
			Assert.assertEquals(String.format("Index=%s; `Stack.apilar` should increment size.", i),
				size + 1, sizeCurrent);
		}

		// do limit case
		try {
			stackConLimite.apilar(cartaRandSupplier.get());
		} catch (StackOverflowException e) {
			return;
		}

		Assert.fail(String.format("Expected an %s to be thrown when `Stack.apilar` is called on limit reached.", 
				StackOverflowException.class));
	}

	/**
	 * Se verifica que al desapilar una pila sin elementos lanza una excepcion.
	 */
	@Test(expected = EmptyStackException.class)
	public void testDesapilarStackSinElementos() {
		stackSinElementos.desapilar();
	}

	/**
	 * Al desapilar una pila con elementos se reduce el numero de elementos de la
	 * misma.
	 */
	@Test
	public void testDesapilarStackConElementos() {
		// given
		for (int i = 0; !stackConElementos.isEmpty(); i++) {
			long size = stackConElementos.size();

			// do
			Integer item = stackConElementos.desapilar();
			long sizeCurrent = stackConElementos.size();

			// assert expectation
			Assert.assertNotNull(String.format("Index=%s; `Stack.desapilar` should return items", i), item);
			Assert.assertEquals(String.format("Index=%s; `Stack.desapilar` should decrement size.", i),
				size - 1, sizeCurrent);
		}
	}

	/**
	 * Devuelve el numero de elementos de la pila sin elementos y de la pila con
	 * elementos.
	 */
	@Test
	public void testGetNumElements() {
		assertThat("Stack without items",  stackSinElementos.size(), is(equalTo(0L)));
		assertThat("Stack with elementos", stackConElementos.size(), is(greaterThan(0L)));
		assertThat("Stack with max limit", stackConLimite.size(),    is(equalTo(0L)));
	}

}
