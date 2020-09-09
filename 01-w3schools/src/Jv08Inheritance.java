// final: The type Car cannot subclass the final class Jv08Inheritance
// final class Jv08Inheritance {
class Jv08Inheritance {
    // private: the Car class would not be able to access it.
    // private String brand = "Ford";
    protected String brand = "Ford";        // Jv08Inheritance attribute
    public void honk() {                    // Jv08Inheritance method
      System.out.println("Tuut, tuut!");
    }
}

class Car extends Jv08Inheritance {
    private String modelName = "Mustang";    // Car attribute
    public static void main(String[] args) {
  
      // Create a myCar object
      Car myCar = new Car();
  
      // Call the honk() method (from the Jv08Inheritance class) on the myCar object
      myCar.honk();
  
      // Display the value of the brand attribute (from the Jv08Inheritance class) and the value of the modelName from the Car class
      System.out.println(myCar.brand + " " + myCar.modelName);
    }
  }
