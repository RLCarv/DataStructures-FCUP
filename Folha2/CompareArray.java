/* 
Dado um numero N [1 - 100] e N numeros de [1 - 100] (mesma linha), 
seguido de P [1 - 100] (em \n) e P sequencias de numeros [1 - 100] (\n cada).
Cada sequencia de numeros começa por k, seguido de k numeros.
Retorna quantas sequencias de numeros (^k) não contem um elemento dos N numeros.
-> Input: N N*numeros \n P (P * \n K K*numeros).
*/

import java.util.Scanner;

public class CompareArray {
    static boolean comparador(int[] numeros, int[] sequencias) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < sequencias.length; j++) {
                if (numeros[i] == sequencias[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // arrays tamanhos n e p e atribuir numeros aos arrays
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            numeros[i] = stdIn.nextInt();
        }

        int p = stdIn.nextInt();

        int contador = 0;

        // cria arrays de tamanho k, atribui valores e compara
        for (int i = 0; i < p; i++) {
            int k = stdIn.nextInt();

            int[] sequencias = new int[k];

            for (int j = 0; j < k; j++) {
                sequencias[j] = stdIn.nextInt();
            }

            if (comparador(numeros, sequencias)) {
                contador++;
            }
        }

        System.out.println(contador);

        stdIn.close();
    }
}
