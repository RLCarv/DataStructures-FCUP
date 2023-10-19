/* Sopa de Letras! Dado um ficheiro de input contendo uma grade com letras aleatórias
e as palavras que queremos encontrar, imprimir o output contendo somente as palavras,
na posição que foram encontradas, e transformando as letras que não fazem parte em '.'
 */

import java.util.Scanner;

class Sopa {
    private int linhas, colunas, num_p;
    private char matriz[][];
    private char matriz_filtrada[][];
    private String palavras[];

    Sopa(int linha, int coluna) {
        linhas = linha;
        colunas = coluna;
        matriz = new char[linha][coluna];

        matriz_filtrada = new char[linha][coluna];
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                matriz_filtrada[i][j] = '.';
            }
        }
    }

    public void read(Scanner stdin) {
        for (int i = 0; i < linhas; i++) {
            String buffer = stdin.next();
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = buffer.charAt(j); // atribui os valores da linha
            }
        }

        num_p = stdin.nextInt();
        palavras = new String[num_p];

        for (int i = 0; i < num_p; i++) {
            palavras[i] = stdin.next();
        }
    }

    private void filtro() {
        for (int p = 0; p < num_p; p++) {
            boolean found = false;
            int counter = 0;
            int start = 0;

            for (int i = 0; i < linhas; i++) {
                start = 0;
                counter = 0;

                for (int j = 0; j < colunas; j++) { // percorre a linha
                    if ((counter < palavras[p].length()) && (matriz[i][j] == palavras[p].charAt(counter))) {
                        if (counter == 0) { // gravar onde a palavra começa no array
                            start = j;
                        }
                        counter++;
                    }
                }

                if (counter == palavras[p].length()) { // se a palavra estiver completa, salve-a
                    for (int k = 0; k < palavras[p].length(); k++) {
                        matriz_filtrada[i][k + start] = palavras[p].charAt(k);
                    }
                    found = true;
                    break;
                }

                start = 0;
                counter = 0;

                for (int j = colunas - 1; j >= 0; j--) { // percorre a linha ao contrário
                    if ((counter < palavras[p].length()) && (matriz[i][j] == palavras[p].charAt(counter))) {
                        if (counter == palavras[p].length()) { // gravar onde a palavra começa no array
                            start = j;
                        }
                        counter++;
                    }
                }

                if (counter == palavras[p].length()) { // se a palavra estiver completa, salve-a
                    for (int k = 0; k < palavras[p].length(); k++) {
                        matriz_filtrada[i][k + start] = palavras[p].charAt(palavras[p].length() - k - 1);
                    }
                    found = true;
                }

                if (found) {
                    break;
                }
            }

            if (found) {
                continue;
            }

            start = 0;
            counter = 0;

            for (int j = 0; j < colunas; j++) {
                start = 0;
                counter = 0;

                for (int i = 0; i < linhas; i++) { // percorre a coluna
                    if ((counter < palavras[p].length()) && (matriz[i][j] == palavras[p].charAt(counter))) {
                        if (counter == 0) { // gravar onde a palavra começa no array
                            start = i;
                        }
                        counter++;
                    }
                }

                if (counter == palavras[p].length()) { // se a palavra estiver completa, salve-a
                    for (int k = 0; k < palavras[p].length(); k++) {
                        matriz_filtrada[k + start][j] = palavras[p].charAt(k);
                    }
                    found = true;
                }

                if (found) {
                    break;
                }
                start = 0;
                counter = 0;

                for (int i = linhas - 1; i >= 0; i--) { // percorre a coluna
                    if ((counter < palavras[p].length()) && (matriz[i][j] == palavras[p].charAt(counter))) {
                        if (counter == palavras[p].length() - 1) { // gravar onde a palavra começa no array
                            start = i;
                        }
                        counter++;
                    }
                }

                if (counter == palavras[p].length()) { // se a palavra estiver completa, salve-a
                    for (int k = 0; k < palavras[p].length(); k++) {
                        matriz_filtrada[k + start][j] = palavras[p].charAt(palavras[p].length() - k - 1);
                    }
                    found = true;
                }

                if (found) {
                    break;
                }
            }

            start = 0;
            counter = 0;
        }
        matriz = matriz_filtrada;
    }

    public void finder() {
        filtro();
    }

    public void write(int num_input) {
        System.out.println("Input #" + num_input);
        for (int i = 0; i < linhas; i++)
            System.out.println(matriz[i]);
    }
}

public class SopadeLetras {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int num_input = 0;
        int linhas = stdin.nextInt();
        int colunas = stdin.nextInt();

        while ((linhas != 0) && (colunas != 0)) { // finaliza em 0 0
            num_input++;

            Sopa sopa = new Sopa(linhas, colunas); // le o input
            sopa.read(stdin);

            sopa.finder(); // acha as palavras na sopa

            sopa.write(num_input); // imprime

            linhas = stdin.nextInt(); // próximo input
            colunas = stdin.nextInt();
        }
    }
}