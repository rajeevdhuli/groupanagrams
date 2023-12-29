interface temp{
    void dance();
}

class Bird{
    public void print(){
        System.out.println("Birds");
    }
}

class Eagle extends Bird implements temp{
    public void sing(){
        System.out.println("sing");
    }
    public void dance(){
        System.out.println("dancing");
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        App a = new App();
        //true
        System.out.println(a instanceof App);
        Eagle e = new Eagle();
        //true
        System.out.println(e instanceof Eagle);
        //true, Since it is sub-class of bird
        System.out.println(e instanceof Bird);
        //true, since it implements temp
        System.out.println(e instanceof temp);
        Bird b = new Bird();
        //true
        System.out.println(b instanceof Bird);
        //false, since it not sub-class of Eagle
        System.out.println(b instanceof Eagle);
        //false, since it doesn't implement temp
        System.out.println(b instanceof temp);
        App a1 = null;
        //false, since a1 doesn't exist
        System.out.println(a1 instanceof App);
    }
}
