public class BoundingBox {
    private Point origin;
    private double width;
    private double height;

    public BoundingBox(Point origin, int width, int height) {
        this.origin = origin;
        this.width = width;
        this.height = height;
    }

    public double getWidth() { return width; }

    public double getHeight() { return height; }

    @Override
    public boolean equals(Object object) {
        BoundingBox b = (BoundingBox)object;
        return ( 
            b.origin.getX() == origin.getX() &&
            b.origin.getY() == origin.getY() &&
            b.getWidth() == width &&
            b.getHeight() == height
        );
    }
    @Override
    public int hashCode() {
        int hash = 11;
        // hash = 29 * hash + x + y;
        return hash;
    }

    @Override
    public String toString() {
        String originStr = "The origin is: " + origin.getX() + ", " + origin.getY() + "\n";
        String sizeStr = "The width is: " + width + " \nThe hiehgt is: " + height + "\n";
        return originStr + sizeStr;
    }
}