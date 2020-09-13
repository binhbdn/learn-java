/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/RulerN.java
 *
 *  Compilation:  javac RulerN.java
 *  Execution:    java RulerN n
 *
 *  Prints the relative lengths of the subdivisions on a ruler or
 *  order n.
 * 
 *  % java RulerN 3
 *   1 
 *   1 2 1 
 *   1 2 1 3 1 2 1 
 *
 *  % java RulerN 5
 *   1 
 *   1 2 1 
 *   1 2 1 3 1 2 1 
 *   1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 
 *   1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 5 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 
 *
 * 
 *  % java RulerN 100
 *  a lot of output, then
 *  Exception in thread "main" java.lang.OutOfMemoryError
 *
 ******************************************************************************/

class RulerN { 
  public static void main(String[] args) { 
    int n = Integer.parseInt(args[0]);
    String ruler = " "; // ruler of order 0
    for (int i = 1; i <= n; i++) { // repeat n times
      ruler = ruler + i + ruler; // concatenate a ruler of order 0, the number i, and a ruler of order 0
      System.out.println(ruler); // print out the final result
    }
  }
}