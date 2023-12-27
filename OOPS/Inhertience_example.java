public class  Inheritence_example {
    public static class Act{
        public void act(){
            System.out.println("ACT");
        }
    }
    public static  class Hero extends Act{
        public void hero(){
            System.out.println("DANCE ");
        }
    }
    public static void main(String[] args) throws Exception {
        Hero h = new Hero(); // Create an instance of Hero using the outer class instance
        h.act();
        h.hero();
    }
}
