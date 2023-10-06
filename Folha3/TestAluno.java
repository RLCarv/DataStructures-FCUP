// Uma classe simples para representar um aluno
class Aluno {
   // Atributos da classe (variáveis para conter informação)
   // Variável contador em comum com todas as instancias de Aluno
   public static int contador = 0;
   String nome;
   int numero;

   // Construtor "padrão"
   Aluno() {
      nome = "indefinido";
      numero = -1;
      contador++;
   }

   // Construtor com parametros, numero tem 9 digitos
   Aluno(String n, int mec) {
      nome = n;
      numero = mec;
      contador++;
   }

   // Metodo que devolve primeiros 4 digitos de Aluno
   int ano() {
      return numero / 100000;
   }

   public String toString() {
      return "(" + nome + "," + numero + ")";
   }
}

// Classe principal contendo o main para testar a classe Aluno
public class TestAluno {
   public static void main(String[] args) {
      System.out.println("contador = " + Aluno.contador);

      Aluno a = new Aluno();
      Aluno b = new Aluno("Manuel", 201506234);
      System.out.println("d = " + a);
      System.out.println("e = " + b);

      Aluno c = new Aluno("Ana", 201408762);
      Aluno d = new Aluno("Bruno", 201508145);
      System.out.println("c ano = " + c.ano() + " d ano = " + d.ano());

      int n = 3;
      Aluno[] e = new Aluno[n];
      // Inicializando o Array, e pondo um aluno() em cada posição
      for (int i = 0; i < n; i++)
         e[i] = new Aluno();

      e[0].nome = "Pedro";
      // imprimindo o Array
      for (int i = 0; i < n; i++)
         System.out.println("e[" + i + "] = " + e[i]);

      System.out.println("contador = " + Aluno.contador);
   }
}