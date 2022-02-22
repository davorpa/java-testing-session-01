package es.seresco.cursojee;
import java.util.Vector;

/**
 * Clase Stack en la que se almacenan datos de la pila.
 * @author Sergio Valdes
 * @see Vector
 * @see Exception
 *
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
	 * Constructor por defecto de la clase que se encarga de inicializar
	 * las propiedades.
	 */
	public Stack(){
		elementos = new Vector<Integer>();
		longitud = 0;
	}
	
	/**
	 * Devuelve <code>true</code> si la pila esta vacia y <code>false</code>
	 * en caso contrario.
	 * @return <code>true</code> o <code>false</code>
	 */
	public boolean stackVacio(){
		if (longitud==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Apila o guarda el elemento pasado como parametro a la pila.
	 * @param o {@link Integer} elemento a añadir
	 */
	public void apilar ( Integer o ) {
		elementos.add(longitud, o);
		longitud++;
	}

	/**
	 * Desapila un elemento de la pila.
	 * @return {@link Integer} elemento obtenido de la pila
	 */
	public Integer desapilar () {
		try {
			if(stackVacio())
				throw new ErrorStackVacio();
			else {
				return elementos.get(--longitud);
			}
		} catch(ErrorStackVacio error) {
			System.out.println("ERROR: el stack está vacio");
			return null;
		}
	}

	/**
	 * Devuelve el numero de elementos de la pila.
	 * @return numero de elementos
	 */
	public int getNumElements() {
		return longitud;
	}

	/**
	 * Excepcion especifica que se produce cuando se realiza 
	 * una accion sobre una pila vacia.
	 * @author Sergio Valdes
	 * @see Exception
	 *
	 */
	@SuppressWarnings("serial")
	class ErrorStackVacio extends Exception {
		public ErrorStackVacio() {
			super();
		}
	}
}