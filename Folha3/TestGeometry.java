// Uma classe simples para representar um ponto 2D
class Point {
    int x, y;

    Point() {
        x = y = 0;
    }

    Point(int x0, int y0) {
        x = x0;
        y = y0;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

// Uma classe que representa retangulos, usando 2 pontos
// p1 = ponto inferior esquerdo; p2 = ponto superior direito
class Rectangle {
    int p1x, p1y, p2x, p2y;

    // Representação através das coordenadas
    Rectangle(int x1, int y1, int x2, int y2) {
        p1x = x1;
        p1y = y1;
        p2x = x2;
        p2y = y2;
    }

    // Representação através de dois Pontos
    Rectangle(Point p1, Point p2) {
        p1x = p1.x;
        p1y = p1.y;
        p2x = p2.x;
        p2y = p2.y;
    }

    // devolve a area
    public int area() {
        int area = (p2x - p1x) * (p2y - p1y);
        return area;
    }

    // devolve o perimetro
    public int perimeter() {
        int perimeter = 2 * (p2x - p1x) + 2 * (p2y - p1y);
        return perimeter;
    }

    // devolve true se o ponto p está dentro do rectângulo
    public boolean pointInside(Point p) {
        if ((p.x >= p1x) && (p.x <= p2x) && (p.y >= p1y) && (p.y <= p2y)) {
            return true;
        }
        return false;
    }

    // devolve true se o rectâgulo r está contido dentro do rectângulo
    public boolean rectangleInside(Rectangle r) {
        if ((r.p1x >= p1x) && (r.p2x <= p2x) && (r.p1y >= p1y) && (r.p2y <= p2y)) {
            return true;
        }
        return false;
    }
}

// Classe principal com a função main
public class TestGeometry {
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 4);
        Point d = new Point(8, 2);

        Rectangle amarelo = new Rectangle(a, c);
        Rectangle laranja = new Rectangle(2, 3, 9, 6);
        Rectangle verde = new Rectangle(3, 4, 4, 5);
        Rectangle azul = new Rectangle(5, 1, 6, 5);
        Rectangle vermelho = new Rectangle(7, 3, 9, 5);

        System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
        System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20

        System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
        System.out.println("Area do retangulo laranja = " + laranja.area()); // 21

        System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
        System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false

        System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde)); // true
        System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul)); // false
        System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true
    }
}
