// Use o arquivo TestMatrix.txt como input

import java.util.Scanner;
import java.util.Random;

class Matrix {
    int data[][]; // os elementos da matriz em si
    int rows; // numero de linhas
    int cols; // numero de colunas

    // construtor padrao de matriz
    Matrix(int r, int c) {
        data = new int[r][c];
        rows = r;
        cols = c;
    }

    // construtor de matriz aleatórias dado r, c, max e min
    Matrix(int r, int c, int min, int max) {
        data = new int[r][c];
        rows = r;
        cols = c;
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
    }

    // Ler os rows x cols elementos da matriz
    public void read(Scanner in) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                data[i][j] = in.nextInt();
    }

    // devolve matriz identidade de tamanho n
    public static Matrix identity(int n) {
        Matrix ident = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            ident.data[i][i] = 1;
        }
        return ident;
    }

    // devolve a matriz transposta
    public Matrix transpose() {
        Matrix transposta = new Matrix(cols, rows);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposta.data[i][j] = data[j][i];
            }
        }
        return transposta;
    }

    // Devolve uma nova matriz que é o resultado da soma da matriz com m
    public Matrix sum(Matrix m) {
        Matrix soma = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                soma.data[i][j] = m.data[i][j] + data[i][j];
            }
        }
        return soma;
    }

    // Devolve uma nova matriz que é o resultado da multiplicação da matriz com m
    public Matrix multiply(Matrix m) {
        Matrix multi = new Matrix(rows, m.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                for (int k = 0; k < m.rows; k++)
                    multi.data[i][j] += data[i][k] * m.data[k][j];
            }
        }
        return multi;
    }

    // Representacao em String da matrix
    public String toString() {
        String ans = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                ans += data[i][j] + " ";
            ans += "\n";
        }
        return ans;
    }
}

public class TestMatrix {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        Matrix m0 = new Matrix(stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.nextInt());
        System.out.println(m0);

        Matrix m1 = Matrix.identity(5);
        System.out.println(m1);

        Matrix m2 = new Matrix(stdin.nextInt(), stdin.nextInt());
        m2.read(stdin);
        System.out.println(m2);
        Matrix m3 = new Matrix(stdin.nextInt(), stdin.nextInt());
        m3.read(stdin);
        System.out.println(m3);
        Matrix m4 = new Matrix(stdin.nextInt(), stdin.nextInt());
        m4.read(stdin);
        System.out.println(m4);

        Matrix m5 = m1.transpose();
        System.out.println(m5);
        Matrix m6 = m2.transpose();
        System.out.println(m6);

        Matrix m7 = m2.sum(m3);
        System.out.println(m7);
        Matrix m8 = m2.multiply(m4);
        System.out.println(m8);
    }
}