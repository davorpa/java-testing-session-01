package es.seresco.cursojee;

public class Calculadora {

	public int sumar(int num1, int num2) {
		return num1 + num2;
	}

	public int multiplicar(int num1, int num2) {
		return num1 * num2;
	}

	public int dividir(int dividendo, int divisor) {
		if (divisor == 0) {
			throw new DivisionByZeroArithmeticException();
		}
		return dividendo / divisor;
	}

	public double dividir(double dividendo, double divisor) {
		if (divisor == 0) {
			throw new DivisionByZeroArithmeticException();
		}
		return dividendo / divisor;
	}

}