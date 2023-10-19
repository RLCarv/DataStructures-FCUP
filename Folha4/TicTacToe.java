/*Dado um tabuleiro de um jogo do galo, com algumas jogadas possivelmente já feitas, 
o analise e diga se algum dos jogadores ganhou. Imagine uma generalização do jogo, 
sempre num tabuleiro quadrado, mas que pode ser de dimensão diferente de 3x3. 
Tal como no original, os jogadores jogam à vez e ganham se conseguirem preencher 
completamente uma linha, uma coluna ou uma diagonal. Input --> "." ou "X" ou "O"*/

import java.util.Scanner;

class Game {
    private int n; // dimension
    private char b[][]; // board

    Game(int size) {
        n = size;
        b = new char[n][n];
    }

    void read(Scanner stdin) {
        for (int i = 0; i < n; i++) {
            String buffer = stdin.next(); // cicla as linhas
            for (int j = 0; j < n; j++) {
                b[i][j] = buffer.charAt(j); // atribui os valores da linha
            }
        }
    }

    void check(int lin, int col, int inc_lin, int inc_col) {
        if (b[lin][col] == '.') { // sequencia incompleta
            return;
        }

        for (int i = 0, x = lin, y = col; i < n; i++, x += inc_lin, y += inc_col) {
            if (b[lin][col] != b[x][y]) { // sequencia não é igual
                return;
            }
        }

        win(b[col][lin]);
    }

    void win(char player) {
        System.out.println("Ganhou o " + player);
        System.exit(0); // fim do código
    }

    boolean finished() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    void status() {
        for (int i = 0; i < n; i++) { // checar as linhas
            check(i, 0, 0, 1);
        }
        for (int j = 0; j < n; j++) { // checar as colunas
            check(0, j, 1, 0);
        }
        check(0, 0, 1, 1); // diagonal principal
        check(0, n - 1, 1, -1); // diagonal secundária

        if (!finished()) {
            System.out.println("Jogo incompleto");
        } else {
            System.out.println("Empate");
        }
    }
}

public class TicTacToe {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        Game game = new Game(stdin.nextInt()); // cria o tabuleiro
        game.read(stdin); // atribui valores ao tabuleiro
        game.status();// checa quem ganhou
        stdin.close();
    }
}