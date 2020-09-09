/*
    Method              Description
    nextBoolean()       Reads a boolean value from the user
    nextByte()	        Reads a byte value from the user
    nextDouble()	    Reads a double value from the user
    nextFloat()	        Reads a float value from the user
    nextInt()	        Reads a int value from the user
    nextLine()	        Reads a String value from the user
    nextLong()	        Reads a long value from the user
    nextShort()	        Reads a short value from the user
*/

import java.util.Scanner; // Import the Scanner class

class Jv14Scanner {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter name, age and salary:");

        // String input
        String name = myObj.nextLine();

        // Numerical input
        int age = myObj.nextInt();
        double salary = myObj.nextDouble();

        // Output input by user
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);

        myObj.close();
    }
}
