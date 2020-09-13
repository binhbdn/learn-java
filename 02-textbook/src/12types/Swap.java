/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/12types/Swap.java
 *
 *  Compilation:  javac Swap.java
 *  Execution:    java Swap a b
 *
 *  Read in two integer command-line arguments a and b and
 *  swap their values using the swapping idiom described on p. 17.
 *  After each assignment statement, use System.out.println() to
 *  print out a trace of the variables.
 *
 *  %  java Swap 11 99
 *  a = 11, b = 99, c = 0
 *  a = 11, b = 99, c = 11
 *  a = 99, b = 99, c = 11
 *  a = 99, b = 11, c = 11
 *
 ******************************************************************************/

class Swap {
  public static void main(String[] args) { 
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = 0;

    System.out.println("a = " + a + ", b = " + b + ", c = " + c); 
    c = a;
    System.out.println("a = " + a + ", b = " + b + ", c = " + c); 
    a = b;
    System.out.println("a = " + a + ", b = " + b + ", c = " + c); 
    b = c;
    System.out.println("a = " + a + ", b = " + b + ", c = " + c); 
  }
}