interface A{
    void methodA();
}
interface B extends A{
    void methodB();
}
interface C extends A{
    void methodB();
}
interface D extends B,C{
    void methodD();
}

class Ex implements D{
    public void methodD(){
        System.out.println("D");
    }
    public void methodB(){
        System.out.println("B");
    }
    public void methodA(){
        System.out.println("A");
    }
}
public class App{
    public static void main(String args[]){
        Ex e = new Ex();
        e.methodD();
        e.methodA();
        e.methodB();
    }
}


