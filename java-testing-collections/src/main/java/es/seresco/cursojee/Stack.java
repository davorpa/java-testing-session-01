package es.seresco.cursojee;

import java.util.Vector;

/**
 * Clase Stack en la que se almacenan datos de la pila.
 */

public class Stack {

	/**
	 * El tamaño de la pila.
	 */
	private int longitud;

	/**
	 * {@link Vector} de {@link Integer} con los elementos de la pila.
	 */
	private Vector<Integer> elementos;

	/**
	 * Constructor por defecto de la clase que se encarga de inicializar las
	 * propiedades.
	 */
	public Stack() {
		elementos = new Vector<>();
		longitud = 0;
	}

	/**
	 * Devuelve <code>true</code> si la pila esta vacia y <code>false</code> en caso
	 * contrario.
	 * 
	 * @return <code>true</code> o <code>false</code>
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Apila o guarda el elemento pasado como parametro a la pila.
	 * 
	 * @param o {@link Integer} elemento a añadir
	 */
	public void apilar(Integer o) {

	}

	/**
	 * Desapila un elemento de la pila.
	 * 
	 * @return {@link Integer} elemento obtenido de la pila
	 */
	public Integer desapilar() {
		return null;
	}

	/**
	 * Devuelve el numero de elementos de la pila.
	 * 
	 * @return numero de elementos
	 */
	public int size() {
		return 0;
	}

	/**
	 * Excepcion especifica que se produce cuando se realiza una accion sobre una
	 * pila vacia.
	 * 
	 * @see Exception
	 */
	@SuppressWarnings("serial")
	class ErrorStackVacio extends Exception {

	}

}
