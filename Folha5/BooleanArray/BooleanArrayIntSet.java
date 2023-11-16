public class BooleanArrayIntSet implements IntSet {
    private int size; // Numero de elementos do conjunto
    private int elem[]; // Array que contem os elementos em si
    private boolean isElem[]; // Boolean array
    private int maxSize; // Guarda o valor do tamanho maximo do array

    BooleanArrayIntSet(int maxSize) { // Construtor que recebe como argumento o numero maximo de elementos
        elem = new int[maxSize + 1];
        isElem = new boolean[maxSize + 1];
        this.maxSize = maxSize;
        size = 0;
    }

    public int size() { // Retorna o numero de elementos do conjunto
        return size;
    }

    public void clear() { // Limpa o conjunto (torna-o vazio)
        isElem = new boolean[maxSize + 1];
        size = 0;
    }

    public boolean contains(int x) { // Retorna true se x esta no conjunto
        if (isElem[x] == true) {
            return true;
        }
        return isElem[x] == true;
    }

    public boolean add(int x) { // Adiciona x ao conjunto (devolve true se conseguir)
        if (!contains(x)) {
            isElem[x] = true;
            elem[size] = x;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int x) { // Remove x do conjunto (devolve true se conseguir)
        if (contains(x)) {
            isElem[x] = false;
            size--;
            elem[x] = elem[size];
            return true;
        }
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
        IntSet temp = new BooleanArrayIntSet(maxSize);
        int IntersecSize = size;
        if (s.size() > size) {
            IntersecSize = s.size();
        }
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
