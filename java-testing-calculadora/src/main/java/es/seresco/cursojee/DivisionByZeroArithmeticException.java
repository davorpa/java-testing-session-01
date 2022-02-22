package es.seresco.cursojee;

public class DivisionByZeroArithmeticException extends ArithmeticException {

	private static final long serialVersionUID = 5579900042827097103L;

	public DivisionByZeroArithmeticException() {
		super("/ by zero");
	}

	public DivisionByZeroArithmeticException(String s) {
		super(s);
	}

}
