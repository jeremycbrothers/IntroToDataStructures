import java.awt.Color;

public abstract class Ellipse extends Figures {
    double x, y, minorAxis, majorAxis;
    Color color;
    public Ellipse(double x, double y, double minorAxis, double majorAxis, Color color) {
       super(x,y,minorAxis,majorAxis,color);
    }

    public double GetX() { return x; }
    public double GetY() { return y; }
    public double getMinorAxis() { return minorAxis; }
    public double getMajorAxis() { return majorAxis; }
    public String getColor() { return color.toString(); }

    protected double araa() {
        return Math.PI * minorAxis * majorAxis;
    }
}