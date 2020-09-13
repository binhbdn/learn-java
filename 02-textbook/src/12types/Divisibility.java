/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/12types/Divisibility.java
 *
 *  Compilation:  javac Divisibility.java
 *  Execution:    java Divisibility x y
 *
 *  Reads in two integer command-line arguments x and y and prints "true"
 *  if both are divisible by 7, and false otherwise.
 *
 *  % java Divisibility 14 21
 *  true
 *
 *  % java Divisibility 4 21
 *  false
 * 
 *  % java Divisibility 100 200
 *  false
 *
 *  a % 7 is the remainder when you divide 7 into a. If the remainder
 *  is 0, then a is divisible by 7.
 *
 ******************************************************************************/

class Divisibility {
  public static void main(String[] args) {
    int x = Integer.parseInt(args[0]);
    int y = Integer.parseInt(args[1]);

    boolean isDivisible = (x % 7 == 0) && (y % 7 == 0);

    System.out.println(isDivisible);
  }
}