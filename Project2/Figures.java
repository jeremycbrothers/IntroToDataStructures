import java.awt.Color;

public abstract class Figures {
    private Color color;
    private boolean visible = true;
    protected double area = 0.0;

    protected abstract double area();
    protected void makeVisible() { visible = true; }
    protected void makeInvisible() { visible = false; }
    protected void setColor(Color color) {
        //Todo figure out how to change a color 
        // based on the color class
    }
    protected void dilate(double factor) {}
    protected void translate(double x_delta, double y_delta) {}
    
    protected static boolean larger(Figures pFigure, Figures sFigure) { 
        return pFigure.area() > pFigure.area();
    }

    public Figures(Color color) {
        this.color = color;
    }

    @override
    public boolean equals() {
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