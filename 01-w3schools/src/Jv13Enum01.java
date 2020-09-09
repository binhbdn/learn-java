// Enum is short for "enumerations", which means "specifically listed"
// enum constants are public, static and final (unchangeable - cannot be overridden)
// An enum cannot be used to create objects,
// and it cannot extend other classes (but it can implement interfaces)
enum MyLevel {
    LOW,
    MEDIUM,
    HIGH
}

class Jv13Enum01 {
    public static void main(String[] args) { 
      MyLevel myVar = MyLevel.MEDIUM;
      System.out.println(myVar);
    } 
}