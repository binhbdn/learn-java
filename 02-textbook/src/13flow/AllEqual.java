/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/AllEqual.java
 *
 *  Compilation:  javac AllEqual.java
 *  Execution:    java AllEqual a b c
 *
 *  Prints "equal" if a = b = c and "not equal" otherwise.
 *
 *  % java AllEqual 10 10 10
 *  all equal
 *
 *  % java AllEqual 10 20 10
 *  not all equal
 *
 ******************************************************************************/

class AllEqual { 
  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = Integer.parseInt(args[2]);

    if (a == b && a == c) {
      System.out.println("all equal");
    }
    else {
      System.out.println("not all equal");
    }
  }
}