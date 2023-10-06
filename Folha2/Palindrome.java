import java.util.Scanner;

public class Palindrome { //diz se a string e um palindromo
    static boolean palindrome(String arg){
        for (int i = 0, j = arg.length() - 1; i < j; i++, j--){
            if (arg.charAt(i) != arg.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int num = stdIn.nextInt();
        System.out.println(num);

        //descartar a primeira linha
        String frase = stdIn.nextLine(); 

        int i = 0;
        do {
            frase = stdIn.nextLine().toLowerCase();
            
            frase = frase.replaceAll("[^a-zA-Z]", ""); 
        
            if (palindrome(frase)){
                System.out.println("sim");
            } else {
                System.out.println("nao");
            };

            i++;
        } while (i < num);

        stdIn.close();
    }
}
