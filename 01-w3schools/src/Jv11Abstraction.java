// Abstract Classes and Methods
// Abstraction can be achieved with either abstract classes or interfaces
// Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class)
// Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from)
// An abstract class can have both abstract and regular methods

// Abstract class
abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void animalSound();
    // Regular method
    public void sleep() {
        System.out.println("The sleeping animal says: Zzz");
    }
  }

// Subclass (inherit from Animal)
class Pig1 extends Animal {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
}

class Jv11Abstraction {
    public static void main(String[] args) {
        Pig1 myPig1 = new Pig1(); // Create a Pig1 object
        myPig1.animalSound();
        myPig1.sleep();
    }
}
