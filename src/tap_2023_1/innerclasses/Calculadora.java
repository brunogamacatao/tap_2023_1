package tap_2023_1.innerclasses;

public class Calculadora {
	public double resultado(double a, double b, Operacao o) {
		return o.opera(a, b);
	}
	
	public static void main(String[] args) {
		System.out.println("Soma super complicada:");
		
		Operacao soma          = (a, b) -> a + b;
		Operacao subtracao     = (a, b) -> a - b;
		Operacao multiplicacao = (a, b) -> a * b;
		Operacao divisao       = (a, b) -> a / b;
		
		Calculadora c = new Calculadora();
		System.out.println(c.resultado(2, 3, soma));
	}
}
