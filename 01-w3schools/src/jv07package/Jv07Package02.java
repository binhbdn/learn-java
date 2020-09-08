package jv07package;

public class Jv07Package02 {
    // Attributes
    final int x = 5;
    int y = 3;

    // Static method
    public static void myStaticMethod() {
        System.out.println("Static methods can be called without creating objects");
    }

    // Public method
    public void myPublicMethod() {
        System.out.println("Public methods must be called by creating objects");
    }
    public static void main(String[] args) {
        System.out.println("This is my package!");
    }
}
