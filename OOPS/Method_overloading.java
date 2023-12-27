public class App {
    public static class Animal{
        public void bark(String res){
            System.out.println(res+" "+"bow");
        }
        public void bark(int num){
            System.out.println((char)num);
        }
    }
    public static class cat extends Animal{
        public void bark(){
            System.out.println("meow");
        }
    }
    public static void main(String[] args) throws Exception {
        cat c = new cat();
        c.bark();
        c.bark(66);
        c.bark("dog");
    }
}
