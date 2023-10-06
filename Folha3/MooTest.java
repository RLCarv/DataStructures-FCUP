class Point {
    int x, y;

    Point(int x0, int y0) {
        x = x0;
        y = y0;
    }

    /*
     * // Devolve uma representação em texto do conteúdo de um Ponto
     * public String toString() {
     * return "(" + x + "," + y + ")";
     * }
     */

}

public class MooTest {
    public static void main(String[] args) {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 2);

        p2.x = 3;
        p2.y = 3;

        System.out.print("p1(" + p1.x + "," + p1.y + ") | ");
        System.out.println("p2(" + p2.x + "," + p2.y + ")");
    }
}
