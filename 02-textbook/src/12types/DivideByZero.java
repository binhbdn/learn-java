/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/12types/DivideByZero.java
 *
 *  Compilation:  javac DivideByZero.java
 *  Execution:    java DivideByZero
 *
 *  Demonstrates what happens when you divide by zero with integers
 *  and doubles.
 * 
 *  % java DivideByZero
 *  17.0 / 0.0 = Infinity
 *  17.0 % 0.0 = NaN
 *  Exception in thread "main" java.lang.ArithmeticException: / by zero
 *
 *
 ******************************************************************************/

class DivideByZero {
  public static void main(String[] args) {
    System.out.println("17.0 / 0.0 = " + (17.0 / 0.0));  // infinity
    System.out.println("17.0 % 0.0 = " + (17.0 % 0.0));  // not a number
    System.out.println("17 / 0 = " + (17 / 0));          // ERROR
    System.out.println("17 % 0 = " + (17 % 0));          // ERROR
  }
}