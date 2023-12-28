abstract class Shape {
    abstract void draw();
}

class Rectangle extends Shape {
    void draw() {
        System.out.println("drawing rectangle");
    }
}

class Circle1 extends Shape {
    void draw() {
        System.out.println("drawing circle");
    }
    void sketch(){
        System.out.println("hi");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Circle1 c = new Circle1();
        c.draw();
        c.sketch();
        Rectangle r = new Rectangle();
        r.draw();
        Shape s = new Circle1();
        s.draw();
    }
}
