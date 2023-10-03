import java.util.Scanner;

public class ReadNumbers {

    // Escrever os numeros guardados num array no stdout
    static void writeArray(int v[]) {
        int max = v[0], min = v[0];
        for (int i = 0; i < v.length; i++) {
            if (v[i] < min) {
                min = v[i];
            } else if (v[i] > max) {
                max = v[i];
            }
            System.out.println("v[" + i + "] = " + v[i]);
        }
        System.out.println("Amplitude = " + (max - min));
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt(); // Ler a quantidade de numeros que se seguem
        int v[] = new int[n]; // Cria um novo array com espaço para 10 inteiros

        for (int i = 0; i < n; i++) // Ler os numeros a partir do stdin
            v[i] = stdin.nextInt();

        writeArray(v); // Chamar procedimento que escreve
        stdin.close();
    }
}