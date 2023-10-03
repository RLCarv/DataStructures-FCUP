public class Square {
    // Desenha uma linha de n caracteres onde:
    // - o primeiro e o último caracteres são o caracter da variável 'a'
    // - todos os outros caracteres são o caracter da variável 'b'
    static void line(char a, char b, int n) {
    
    System.out.print(a); //primeira linha
	for (int i=1; i<=n-2; i++)
	    System.out.print(b);
	System.out.println(a);
    
    for (int i=0; i<n-2; i++){ //linhas do meio
        System.out.print("|");
        for (int j=0; j<n-2; j++)
            System.out.print(".");
        System.out.println("|");
    }
    
    System.out.print(a); //ultima linha
	for (int i=1; i<=n-2; i++)
	    System.out.print(b);
	System.out.println(a);

    }

    // O procedimento executado inicialmente é sempre o main
    public static void main(String[] args) {	
	line('*','-',8);	    
    }
}