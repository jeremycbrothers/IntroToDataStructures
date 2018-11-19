public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    
    @Override
    public boolean equals(Object object) {
        Point p = (Point)object;
        return x == p.getX() && y == p.getY();
    }

    @Override
    public int hashCode() {
        int hash = 11;
        // hash = 29 * hash + x + y;
        return hash;
    }

    @Override
    public String toString() {
        return "X: " + x + " Y: " + y;
    }
}