public class Rectangle implements Shape{
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
       this.length = length;
       this.breadth = breadth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    public double area() {
        return this.length * this.breadth;
    }

    public double square() {
        return Math.pow(this.length, 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return Double.compare(rectangle.length, length) == 0 &&
               Double.compare(rectangle.breadth, breadth) == 0;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
               "length=" + length +
               ", breadth=" + breadth +
               '}';
    }
}