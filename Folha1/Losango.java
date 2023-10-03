// Imprime Losangos para um dado N

public class Losango { // gera losango
    static void losango(int num) { // usa apenas impares
        // crescente, i > 1 pois não queremos a iteração i = 1
        // já que ela será representada na metade
        for (int i = num, j = 1; i > 1; i = i - 2, j = j + 2) {
            for (int space = i / 2; space > 0; space--) {
                System.out.print(" ");
            }
            for (int hashtag = j; hashtag > 0; hashtag--) {
                System.out.print("#");
            }
            for (int space = i / 2; space > 0; space--) {
                System.out.print(" ");
            }
            System.out.print("\n");
        }

        // hashtags na metade
        for (int i = 0; i < num; i++) {
            System.out.print("#");
        }
        System.out.print("\n");

        // decrescente, i = 3 pois queremos começar a partir
        // da metade, e não queremos a iteração i = 1
        for (int i = 3, j = num - 2; i <= num; i = i + 2, j = j - 2) {
            for (int space = i / 2; space > 0; space--) {
                System.out.print(" ");
            }
            for (int hashtag = j; hashtag > 0; hashtag--) {
                System.out.print("#");
            }
            for (int space = i / 2; space > 0; space--) {
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]) {
        losango(9);
    }
}
