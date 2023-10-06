import java.util.Scanner;

public class MediaMaxMin {
    public static void main(String[] args) {
        // input
        Scanner stdIn = new Scanner(System.in);
        int num = stdIn.nextInt();

        // descartar primeira linha e atribuir max
        stdIn.nextLine();
        int maxvalue = stdIn.nextInt();
        int minvalue = maxvalue;
        double soma = maxvalue;

        // atribuir numeros e definir max
        for (int i = 1; i < num; i++) {
            int value = stdIn.nextInt();
            soma = soma + value;
            if (value > maxvalue) {
                maxvalue = value;
            } else if (value < minvalue) {
                minvalue = value;
            }
        }

        // calcular media e amplitude
        double media = soma / (double) num;
        int amplitude = maxvalue - minvalue;

        // impimir
        System.out.printf("%.2f\n", media);
        System.out.println(amplitude);
        stdIn.close();
    }
}
