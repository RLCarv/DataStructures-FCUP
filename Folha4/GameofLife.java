/*Game of Life é um autómato celular proposto em 1970 pelo matemático britânico John Horton Connway.
Desenvolve-se numa grelha infinita, na qual cada célula pode estar ocupada por um organismo ou não.
Células ocupadas dizem-se que estão vivas e as não ocupadas dizem-se mortas. Em cada geração as células 
que estão vivas mudam o seu estado em função do número de células vizinhas que estão vivas de acordo com as seguintes regras:

    .Os vizinhos de uma célula são as 8 células que a tocam na horizontal, vertical ou diagonal.
    .Se uma célula estiver viva e o número de células vizinhas vivas for 0 ou 1, então na geração seguinte a célula morre de solidão.
    .Se uma célula está viva e tem 4 ou mais células vizinhas também vivas, então na geração seguinte a célula morre de sobre-povoamento.
    .Uma célula viva com 2 ou 3 células vizinhas vivas, continua viva na geração seguinte.
    .Se uma célula morta tiver exactamente 3 células vizinhas vivas, muda para o estado de célula viva na geração seguinte.
    .Todos os nascimentos e mortes de células têm lugar em simultâneo, isto é as alterações têm por base o estado actual e nunca o estado futuro.

Neste problema vamos considerar que a grelha é finita e que as células que a envolvem estão sempre mortas.*/

import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD = '.'; // Constante que indica uma celula morta
    final char ALIVE = 'O'; // Constante que indica uma celula viva
    private int rows, cols; // Numero de linhas e colunas
    private char m[][]; // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
        rows = r;
        cols = c;
        m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
        for (int i = 0; i < rows; i++)
            m[i] = in.next().toCharArray();
    }

    // Metodo para escrever a matriz m[][]
    public void write() {
        for (int i = 0; i < rows; i++)
            System.out.println(m[i]);
    }

    public boolean inBounds(int y, int x) {
        if (y >= 0 && y < rows && x >= 0 && x < cols) {
            return true;
        }
        return false;
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
        int count = 0;

        if (inBounds(y - 1, x - 1)) { // esquerda-superior
            if (m[y - 1][x - 1] == ALIVE) {
                count++;
            }
        }

        if (inBounds(y - 1, x)) { // superior
            if (m[y - 1][x] == ALIVE) {
                count++;
            }
        }

        if (inBounds(y - 1, x + 1)) { // direita-sup
            if (m[y - 1][x + 1] == ALIVE) {
                count++;
            }
        }

        if (inBounds(y, x - 1)) { // esquerda
            if (m[y][x - 1] == ALIVE) {
                count++;
            }
        }

        if (inBounds(y, x + 1)) { // direita
            if (m[y][x + 1] == ALIVE) {
                count++;
            }
        }

        if (inBounds(y + 1, x - 1)) { // esquerda-inferior
            if (m[y + 1][x - 1] == ALIVE) {
                count++;
            }
        }

        if (inBounds(y + 1, x)) { // inferior
            if (m[y + 1][x] == ALIVE) {
                count++;
            }
        }

        if (inBounds(y + 1, x + 1)) { // direita-inferior
            if (m[y + 1][x + 1] == ALIVE) {
                count++;
            }
        }

        return count;
    }

    // Cria nova geracao a partir da actual
    public void iterate() {
        char m2[][] = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = countAlive(i, j);

                switch (count) {
                    case 2:
                        if (m[i][j] == ALIVE) {
                            m2[i][j] = ALIVE;
                        } else {
                            m2[i][j] = DEAD;
                        }
                        break;

                    case 3:
                        m2[i][j] = ALIVE;
                        break;

                    default:
                        m2[i][j] = DEAD;
                }
            }
        }

        m = m2;
    }
}

// Classe principal com o main()
public class GameofLife {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ler linhas, colunas e numero de iteracoes
        int rows = in.nextInt();
        int cols = in.nextInt();
        int n = in.nextInt();

        // Criar objecto para conter o jogo e ler estado inicial
        Game g = new Game(rows, cols);
        g.read(in);

        // Itera cada geração
        for (int i = 0; i < n; i++) {
            g.iterate();
        }

        // Imprime a geração final
        g.write();
    }
}