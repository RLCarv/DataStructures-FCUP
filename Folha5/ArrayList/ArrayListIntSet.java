public class ArrayListIntSet implements IntSet {
    private int size; // Numero de elementos do conjunto
    private int elem[]; // Array que contem os elementos em si

    ArrayListIntSet(int maxSize) { // Construtor que recebe como argumento o numero maximo de elementos
        elem = new int[maxSize];
        size = 0;
    }

    public int size() { // Retorna o numero de elementos do conjunto
        return size;
    }

    public void clear() { // Limpa o conjunto (torna-o vazio)
        size = 0;
    }

    public boolean contains(int x) { // Retorna true se x esta no conjunto
        for (int i = 0; i < size; i++) {
            if (elem[i] == x) {
                return true;
            }
        }
        return false;
    }

    public boolean add(int x) { // Adiciona x ao conjunto (devolve true se conseguir)
        if (!contains(x)) {
            elem[size] = x;
            size++;

            // ystem.out.println("True");
            return true;
        }
        // System.out.println("False");
        return false;
    }

    public boolean remove(int x) { // Remove x do conjunto (devolve true se conseguir)
        if (contains(x)) {
            int i = 0;
            while (elem[i] != x) {
                i++;
            }
            size--;
            elem[i] = elem[size];
            // System.out.println("True");
            return true;
        }
        // System.out.println("False");
        return false;
    }

    public boolean equals(IntSet s) { // Retorna true se ambos os conjuntos sao iguais
        if (size != s.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!s.contains(elem[i])) {
                return false;
            }
        }
        return true;
    }

    public IntSet intersection(IntSet s) { // devolve um novo conjunto: a intersecao de ambos
        int IntersecSize = size;
        if (s.size() > size) {
            IntersecSize = s.size();
        }
        IntSet temp = new ArrayListIntSet(IntersecSize);
        for (int i = 0; i < IntersecSize; i++) {
            if (s.contains(elem[i])) {
                temp.add(elem[i]);
            }
        }
        return temp;
    }

    public String toString() { // imprimir com a formatacao correta
        String res = "{";
        for (int i = 0; i < size; i++) {
            if (i > 0)
                res += ",";
            res += elem[i];
        }
        res += "}";
        return res;
    }
}
