/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/12types/SumOfSines.java
 *
 *  Compilation:  javac SumOfSines.java
 *  Execution:    java SumOfSines t
 *
 *  Read in an angle t (in degrees) and print sin(2t) + sin(3t).
 *
 *  % java SumOfSines 30
 *  1.8660254037844386
 *
 ******************************************************************************/

class SumOfSines {
  public static void main(String[] args) {
    double degrees = Double.parseDouble(args[0]);
    double radians = Math.toRadians(degrees);
    double sum = Math.sin(2 * radians) + Math.sin(3 * radians);
    System.out.println(sum);
  }
}