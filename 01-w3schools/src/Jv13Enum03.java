// Enum in a Switch Statement
// Enums are often used in switch statements to check for corresponding values:
enum Level {
    LOW,
    MEDIUM,
    HIGH
}

class Jv13Enum03 {
    public static void main(String[] args) {
        Level myVar = Level.MEDIUM;
    
        switch(myVar) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }

        // Loop Through an Enum
        // Enum type has a values() method, which returns an array of all enum constants
        for (Level myVar1 : Level.values()) {
            System.out.println(myVar1);
          }
    }
}
