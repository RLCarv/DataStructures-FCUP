/*
 * Decompoe numeros inteiros em fatores primos
 */

public class Decompor {
    static boolean isPrime(int x) { // checa se é primo
        for (int i = 2; i * i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void decompor(int num) {
        String divisores = num + " = ";
        int dividendo = num;

        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                while (dividendo % i == 0) {
                    divisores = divisores + i;
                    dividendo = dividendo / i;
                    if (dividendo > 1) {// se = 1 não precisa
                        divisores = divisores + " * ";
                    }
                }
            }
        }
        System.out.println(divisores);
    }

    public static void main(String[] args) {
        decompor(88);
    }
}
