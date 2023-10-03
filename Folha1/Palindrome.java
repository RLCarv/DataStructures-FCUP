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
        if (palindrome("hello")){
            System.out.println("true");
        } else {
            System.out.println("false");
        };

    }
}
