package Week4;

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



    @Override
    public String toString() {
        return "Rectangle{" +
               "length=" + length +
               ", breadth=" + breadth +
               '}';
    }
}