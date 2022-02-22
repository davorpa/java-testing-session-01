package es.seresco.cursojee;

/**
 * Excepción específica que se produce cuando se realiza una acción sobre una
 * pila que ha alcanzado su límite máximo preestablecido.
 * 
 * @see IllegalStateException
 */
public class StackOverflowException extends IllegalStateException {

	/**
	 * Use serialVersionUID from JDK 1.1.X for interoperability
	 */
	private static final long serialVersionUID = 2964223467546694924L;

	/**
	 * El límite de elementos máximo de la pila.
	 */
	private final long limite;

	public StackOverflowException(long limite) {
		super(String.format("La pila ha sobrepasado su límite máximo de %s elementos.", limite));
		this.limite = limite;
	}

	public StackOverflowException(long limite, Throwable cause) {
		super(String.format("La pila ha sobrepasado su límite máximo de %s elementos.", limite));
		this.limite = limite;
		initCause(cause);
	}

	/**
	 * El límite de elementos máximo de la pila.
	 * @return
	 */
	public long getStackMaxSize() {
		return this.limite;
	}

}