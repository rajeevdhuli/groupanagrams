class Animal {
    private String species;
    public void displaySpecies() {
        System.out.println("Species: " + species);
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String breed) {
        super();
        this.breed = breed;
        System.out.println("A dog of breed " + breed + " is created.");
    }

    public void displayBreed() {
        System.out.println("Breed: " + breed);
    }
}

public class App {
    public static void main(String[] args) {
        Dog myDog = new Dog("Labrador");
        myDog.displaySpecies(); // Output: Species: Canine
        myDog.displayBreed();  // Output: Breed: Labrador
    }
}






class Animal {
    private String species;
    public Animal(String species){
        this.species = species;
    }
    public void displaySpecies() {
        System.out.println("Species: " + species);
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String species,String breed) {
        super(species);
        this.breed = breed;
        System.out.println("A dog of breed " + breed + " is created.");
    }

    public void displayBreed() {
        System.out.println("Breed: " + breed);
    }
}

public class App {
    public static void main(String[] args) {
        Dog myDog = new Dog("Canine","Labrador");
        myDog.displaySpecies(); // Output: Species: Canine
        myDog.displayBreed();  // Output: Breed: Labrador
    }
}

