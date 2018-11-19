import java.awt.Color;

public class Rectangle extends Figures{
    double x, y, width, height; Color color;
    public Rectangle(double x, double y, double width, double height, Color color) {
        super(x, y, width, height, color);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public Color  getColor() { return color; }

    @Override
    protected double area() {
        return width * height;
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}