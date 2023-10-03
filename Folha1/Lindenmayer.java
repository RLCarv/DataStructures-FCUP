/*
 * Imprime o algoritmo de Lindenmayer para um dado N
 */

public class Lindenmayer {
    static void linden(int num) {
        String lindenmayer = "A";
        String temp;
        System.out.println(lindenmayer);

        for (int i = 1; i < num; i++) {
            temp = "";
            for (int j = 0; j < lindenmayer.length(); j++) {
                if (lindenmayer.charAt(j) == 'A') {
                    temp = temp + "AB";
                }
                if (lindenmayer.charAt(j) == 'B') {
                    temp = temp + "A";
                }
            }
            lindenmayer = temp;
            System.out.println(lindenmayer);
        }
    }

    public static void main(String[] args) {
        linden(7);
    }
}
