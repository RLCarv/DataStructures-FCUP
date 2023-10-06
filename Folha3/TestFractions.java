class Fraction {
    int numerador;
    int denominador;

    // Construtor padrão
    Fraction() {
        numerador = denominador = 0;
    }

    // Construtor com parametros
    Fraction(int num, int den) {
        numerador = num;
        denominador = den;
    }

    // Soma f a fração
    public Fraction add(Fraction f) {
        Fraction soma = new Fraction();
        soma.denominador = denominador * f.denominador;
        soma.numerador = (numerador * f.denominador) + (f.numerador * denominador);
        return soma;
    }

    // Multiplica f pela fração
    public Fraction multiply(Fraction f) {
        Fraction multiply = new Fraction();
        multiply.denominador = denominador * f.denominador;
        multiply.numerador = numerador * f.numerador;
        return multiply;
    }

    // Inverte a fração
    public Fraction inverse() {
        Fraction inverse = new Fraction();
        inverse.numerador = denominador;
        inverse.denominador = numerador;
        return inverse;
    }

    // Algoritmo para achar mdc
    public int euclides(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return euclides(b, a % b);
        }
    }

    // Simplifica a fração
    public void simplify() {
        int mdc = euclides(numerador, denominador);
        denominador /= mdc;
        numerador /= mdc;
    }

    // Representacao em String da matrix
    public String toString() {
        if (numerador < denominador) {
            return numerador + "/" + denominador;
        } else if (numerador == denominador) {
            return numerador + "";
        } else {
            return numerador + "/" + denominador + " = " +
                    (numerador / denominador) +
                    " + " + (numerador % denominador) +
                    "/" + denominador;
        }
    }
}

public class TestFractions {
    public static void main(String[] args) {
        Fraction f0 = new Fraction(18, 48);
        f0.simplify();
        System.out.println(f0);

        Fraction f1 = new Fraction(15, 24);
        f1.simplify();
        System.out.println(f1);

        Fraction f2 = f0.add(f1);
        f2.simplify();
        System.out.println(f2);

        Fraction f3 = f0.multiply(f1);
        System.out.println(f3);

        Fraction f4 = f3.inverse();
        f4.simplify();
        System.out.println(f4);

    }
}
