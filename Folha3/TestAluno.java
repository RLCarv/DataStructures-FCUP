// Uma classe simples para representar um aluno
class Aluno {
   // Atributos da classe (variáveis para conter informação)
   String nome;
   int numero;

   // Construtor "padrão"
   Aluno() {
      nome = "indefinido";
      numero = -1;
   }

   public String toString() {
      return "(" + nome + "," + numero + ")";
   }
}

// Classe principal contendo o main para testar a classe Aluno
public class TestAluno {
   public static void main(String[] args) {
      Aluno a = new Aluno();

      System.out.println("a.nome = " + a.nome);
      System.out.println("a.numero = " + a.numero);
      System.out.println("a = " + a);

      Aluno b = new Aluno();
      Aluno c = b;
      b.nome = "modificado";
      System.out.println("b = " + b);
      System.out.println("c = " + c);
   }
}