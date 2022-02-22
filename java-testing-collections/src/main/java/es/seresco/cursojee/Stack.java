package es.seresco.cursojee;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase Stack en la que se almacenan datos de la pila.
 * 
 * @param <T>
 */
public class Stack<T> {

	/**
	 * El tamaño actual de la pila.
	 */
	private long longitud;

	/**
	 * El tamaño máximo de la pila.
	 */
	private final long limite;

	/**
	 * {@link List} de {@link T} con los elementos de la pila.
	 */
	private List<T> elementos;

	/**
	 * Constructor por defecto de la clase que se encarga de inicializar las
	 * propiedades.
	 *
	 * Se encarga de crear una pila vacía sin límite de elementos preestablecido.
	 */
	public Stack() {
		this(-1);
	}

	/**
	 * Permite crear una pila vacía con un límite máximo de elementos preestablecido.
	 *
	 * @param limite, un número negativo permite no tener máximo.
	 */
	public Stack(final long limite) {
		this(limite, List.of());
	}

	/**
	 * Permite crear una pila sin límite máximo con los susodichos elementos.
	 *
	 * @param elementos
	 */
	@SafeVarargs
	public Stack(final T... elementos) {
		this(-1, List.of(elementos));
	}

	/**
	 * Permite crear una pila con límite máximo y con los susodichos elementos..
	 *
	 * @param limite, un número negativo permite no tener máximo.
	 * @param elementos
	 */
	public Stack(final long limite, final Collection<T> elementos) {
		super();
		this.limite = limite;
		this.elementos = new LinkedList<>();
		elementos.forEach(this::apilar);
	}

	@Override
	public String toString() {
		return this.elementos.toString();
	}

	/**
	 * Devuelve <code>true</code> si la pila esta vacía y <code>false</code> en caso
	 * contrario.
	 * 
	 * @return <code>true</code> o <code>false</code>
	 */
	public boolean isEmpty() {
		return this.longitud == 0;
	}

	/**
	 * Devuelve <code>true</code> si la pila esta completa en caso de haberla configurado
	 * para tal límite máximo.
	 * 
	 * @return <code>true</code> o <code>false</code>
	 */
	public boolean isFull() {
		return this.limite > -1 && this.longitud >= this.limite;
	}

	/**
	 * Apila o guarda el elemento pasado como parámetro a la estructura de datos.
	 * 
	 * @param item {@link T} elemento a agregar
	 */
	public void apilar(final T item) {
		checkFull();
		this.elementos.add(0, item);
		this.longitud++;
	}

	void checkFull() {
		if (isFull()) {
			throw new StackOverflowException(this.limite);
		}
	}

	/**
	 * Desapila un elemento de la estructura de datos.
	 * 
	 * @return {@link T} elemento obtenido de la pila
	 */
	public T desapilar() {
		T item;
		checkEmpty();
		item = this.elementos.remove(0);
		this.longitud--;
		return item;
	}

	void checkEmpty() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
	}

	/**
	 * Devuelve el número de elementos de la pila.
	 * 
	 * @return número de elementos
	 */
	public long size() {
		return this.longitud;
	}

}
