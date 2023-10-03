//Conta a ocorrencia de um char em uma string

public class Ocorrencias {
    static void ocorre(String palavra, char letra) {
        int contador = 0;
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                contador++;
            }
        }
        System.out.println(contador);
    }

    public static void main(String[] args) {
        ocorre("algoroooitmooo", 'o');
    }
}
