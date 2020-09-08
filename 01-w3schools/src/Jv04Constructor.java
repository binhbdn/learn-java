// All classes have constructors by default: if you do not create a class constructor yourself,
// Java creates one for you. However, then you are not able to set initial values for object attributes.
public class Jv04Constructor {
    // Create a class attributes:
    int modelYear;
    String modelName;

    // Create a class constructor for the Jv04Constructor class:
    public Jv04Constructor(int year, String name) {
      // Set the initial value for the class attributes:
      modelYear = year;
      modelName = name;
    }
  
    public static void main(String[] args) {
      Jv04Constructor myCar = new Jv04Constructor(1969, "Mustang"); // Create an object of class Jv04Constructor (This will call the constructor)
      System.out.println(myCar.modelYear + " " + myCar.modelName);
    }
  }

  // Outputs 1969 Mustang