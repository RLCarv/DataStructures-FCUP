import java.util.Scanner;

public class PrimesSieve {
    /*
     * //Time Limited :/
     * 
     * // cerifica se o número n é primo
     * static boolean isPrime(int n) {
     * for (int i = 2; i * i <= n; i++) {
     * if (n % i == 0) {
     * return false;
     * }
     * }
     * return true;
     * }
     * 
     * // conta quantos primos tem
     * static int countPrime(int min, int max) {
     * int counter = 0;
     * for (int i = min; i <= max; i++) {
     * if (isPrime(i)) {
     * counter++;
     * }
     * }
     * return counter;
     * }
     */

    // vou tentar com Sieve, se der Time Limit Exceeded só Segemented Sieve...
    static boolean[] isEratostenes(int num) {
        // criando e iniciando o array com tudo true
        boolean[] primes = new boolean[num + 1];
        for (int i = 2; i <= num; i++) {
            primes[i] = true;
        }

        // se é primo, os multiplos são falsos
        for (int i = 2; i <= num; i++) {
            if (primes[i]) {
                for (int j = i; j <= num; j = j + i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        // recebe e designa os 2 numeros (separados por " ")
        Scanner stdIn = new Scanner(System.in);

        int a = stdIn.nextInt();
        int b = stdIn.nextInt();

        stdIn.close();

        // cria um array de booleans de tamanho b
        boolean[] primes = isEratostenes(b);

        // contar os primos
        int contador = 0;
        for (int i = a; i <= b; i++) {
            if (primes[i]) {
                contador++;
            }
        }
        System.out.println(contador);
    }
}