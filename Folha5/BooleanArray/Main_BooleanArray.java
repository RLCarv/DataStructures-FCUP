// Implementar de forma eficiente boolean arrays de forma que o tempo de execução seja minimo mesmo para valores muito altos de n
public class Main_BooleanArray {
    public static void main(String[] args) {
        int n = 1000000;
        IntSet s = new BooleanArrayIntSet(n); // Criar array de booleanos para numeros no intervalo [1,n]
        boolean tmp; // executar "time java Main_BooleanArray"

        System.out.println("Adicionando todos os numeros entre 1 e " + n + "...");
        for (int i = 1; i <= n; i++)
            tmp = s.add(i);

        System.out.println("Adicionando novamente todos os numeros entre 1 e " + n + "...");
        for (int i = 1; i <= n; i++)
            tmp = s.add(i);

        System.out.println("Verificando se todos os numeros entre 1 e " + n + " existem...");
        for (int i = 1; i <= n; i++)
            tmp = s.contains(i);

        System.out.println("Removendo todos os numeros entre 1 e " + n + "...");
        for (int i = 1; i <= n; i++)
            tmp = s.remove(i);
    }
}
