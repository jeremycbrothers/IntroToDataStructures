import java.awt.Color;

public class Square extends Rectangle {

    public Square(double x, double y, double length, Color color) {
        Super(x,y,length,length,color);
    }

    protected double area() {
        return sqr(length);
    }
}