public class Jv01Tutorial {
    public static void main(String[] args) throws Exception {
        // 8 Primitive Data Types:
        // byte; short; int; long; float; double; boolean; char;
        byte myByteNum = 5; // 1 byte | from -128 to 127
        System.out.println(myByteNum);
        short myShortNum = 7; // 2 bytes | from -32,768 to 32,767
        System.out.println(myShortNum);
        int myIntNum; // 4 bytes | from -2,147,483,648 to 2,147,483,647
        // final int myConstIntNum = 7; // const
        long myLongNum = 5000000000L; // 8 bytes | from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        System.out.println(myLongNum);

        float myFloatNum = 5.75f; // 4 bytes | from 3.4e−038 to 3.4e+038, storing 6 to 7 decimal digits
        myFloatNum = 35e3f;
        System.out.println(myFloatNum);
        double myDoubleNum = 19.99d; // 8 bytes | from 1.7e−308 to 1.7e+308, storing 15 decimal digits
        myDoubleNum = 12E4d;
        System.out.println(myDoubleNum);

        boolean myBool = true; // 1 bit
        System.out.println(myBool);
        char myChar = 'B'; // 2 bytes, surrounded by single quotes
        myChar = 65; // can use ASCII values
        System.out.println(myChar);

        // Non-Primitive Data Types
        // Strings; Arrays; Classes; Interface, etc
        // String - are predefined (already defined) in Java
        // Arrays; Classes; Interface, etc : are created by the programmer and is not defined by Java
        String greeting = "Hello World"; // surrounded by double quotes
        System.out.println(greeting);
        System.out.println("The length of the greeting string is: " + greeting.length());
        System.out.println(greeting.toUpperCase());   // Outputs "HELLO WORLD"
        System.out.println(greeting.toLowerCase());   // Outputs "hello world"

        // Type Casting
        // Widening Casting (automatically)
        // byte -> short -> char -> int -> long -> float -> double
        myIntNum = 9;
        myDoubleNum = myIntNum;  // Automatic casting: int to double
        System.out.println(myIntNum); // Outputs 9
        System.out.println(myDoubleNum); // Outputs 9.0

        // Narrowing Casting (manually)
        // double -> float -> long -> int -> char -> short -> byte
        myDoubleNum = 9.87d;
        myIntNum = (int) myDoubleNum; // Manual casting: double to int
        System.out.println(myDoubleNum); // Outputs 9.87
        System.out.println(myIntNum); // Outputs 9

        // Arrays
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        cars[0] = "Opel";
        System.out.println(cars[0]);
        System.out.println(cars.length);
        for (String i : cars) {
            System.out.println(i);
        }

        // Multidimensional Arrays
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        System.out.println(myNumbers[1][2]); // Outputs 7
        for (int i = 0; i < myNumbers.length; ++i) {
            for(int j = 0; j < myNumbers[i].length; ++j) {
              System.out.println(myNumbers[i][j]);
            }
        }
    }
}
