class Shapes {
    double area;

    // Constructor Overloading
    Shapes() {
        area = 0;
    }

    Shapes(double radius) {
        area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    Shapes(double length, double breadth) {
        area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }

    // Method Overloading
    void area(int side) {
        area = side * side;
        System.out.println("Area of Square: " + area);
    }

    void area(double base, double height) {
        area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }

    public static void main(String[] args) {
        Shapes s1 = new Shapes(5);          // Circle
        Shapes s2 = new Shapes(4, 6);       // Rectangle

        Shapes s3 = new Shapes();
        s3.area(4);                         // Square
        s3.area(3.0, 5.0);                  // Triangle
    }
}