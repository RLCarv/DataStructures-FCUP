// Imprime os numeros de 1 a N, e a soma.

public class Numbers {
	public static void main(String[] args) {
		int n = 10; // limite dos numeros
		int soma = 0;

		System.out.print("Numeros de 1 a " + n + ": "); // + é o operador de concatenação de strings
		for (int i = 1; i <= n - 1; i++) {
			System.out.print(i + ", ");
			soma += i;
		}
		soma += 10;

		System.out.println(n);
		System.out.println("Soma = " + soma);
	}
}