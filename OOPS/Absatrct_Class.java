abstract class Shape {
    //abstract method
    abstract void draw();
    //concrete method
    void dance(){
        System.out.println("dance");
    }
}

class Rectangle extends Shape {
    // sub-class which extends or inherits sbase-class(Shape)
    void draw() {
        System.out.println("drawing rectangle");
    }
}

class Circle1 extends Shape {
    //abstract- method should be compulsarly implemented by sub class
    void draw() {
        System.out.println("drawing circle");
    }
    //Additional method
    void sketch(){
        System.out.println("hi");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        //creating an object for circle1
        Circle1 c = new Circle1();
        //for c all function of shape as well Circle1 can be implemented.
        c.draw();
        c.sketch();
        c.dance();
        Rectangle r = new Rectangle();
        r.draw();
        r.dance();
        Shape s = new Circle1();
        //you cannot put method of circle1 like sketch(), and u cannot instatiatze object for absatrct class shape.
        s.draw();
        s.dance();
    }
}
