import java.awt.Color;

public abstract class Figures {
    private BoundingBox box;
    private Color color;
    private boolean visible = true;
    protected double area = 0.0;

    public Figures(double x, double y, double width, double height, Color color) {
        
    }

    protected abstract double area();
    protected void makeVisible() { visible = true; }
    protected void makeInvisible() { visible = false; }
    protected void setColor(Color color) {
        this.color = new Color(color.getRGB());
    }
    protected void dilate(double factor) {}
    protected void translate(double x_delta, double y_delta) {}
    
    protected static boolean larger(Figures pFigure, Figures sFigure) { 
        return pFigure.area() > pFigure.area();
    }

    public Figures(Color color) {
        this.color = color;
    }

    public boolean equals(Object object) {
        // if(this == object) return true;
        // if(object == null) return false;
        // if(getClass() != object.getClass()) return false;

        // // cast the object to be type of student
        // Figures f = (Figures) object;
        // return (
        //     color.equals(object.color) &&
        //     box.equals(object.box) &&
        //     visible == object.visible &&
        //     area == object.area
        // );
        return false;
    }

    public int hashCode() {
        int hash = 11;
        // hash = 29 * hash + color.getRGB + box.getHeight() + box.getWidth() + area;
        return hash;
    }

    @Override
    public String toString() {
        String figureStr = "Area is " + area + "\nVisible is " + visible;
        return figureStr + box.toString() + color.toString();
    }
}