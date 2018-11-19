import java.awt.Color;

public class Circle extends Ellipse {
    double radius;
    public Circle(double x, double y, double radius, Color color) {
        super(x, y, radius, radius, color);
    }

    protected double area() { return Math.PI * (radius * radius); }
}