// class Animal {
class Jv09Polymorphism {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
  }
  
  class Pig extends Jv09Polymorphism {
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }
  }
  
  class Dog extends Jv09Polymorphism {
    public void animalSound() {
        System.out.println("The dog says: bow wow");
    }
  }
  
  class MyMainClass {
    public static void main(final String[] args) {
        final Jv09Polymorphism myJv09Polymorphism = new Jv09Polymorphism(); // Create a Jv09Polymorphism object
        final Jv09Polymorphism myPig = new Pig(); // Create a Pig object
        // final Pig myPig = new Pig(); // OK
        final Jv09Polymorphism myDog = new Dog(); // Create a Dog object
        // final Dog myDog = new Dog(); // OK

        myJv09Polymorphism.animalSound();
        myPig.animalSound();
        myDog.animalSound();
    }
  }