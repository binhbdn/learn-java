/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/Ex.java
 *
 *  Compilation:  javac Ex.java
 *  Execution:    java Ex n
 *  
 *  Prints out an X of radius n like the one below.
 *
 *  % java Ex 3
 *  * . . . . . * 
 *  . * . . . * . 
 *  . . * . * . . 
 *  . . . * . . . 
 *  . . * . * . . 
 *  . * . . . * . 
 *  * . . . . . * 
 *
 *  % java Ex 5
 *  * . . . . . . . . . * 
 *  . * . . . . . . . * . 
 *  . . * . . . . . * . . 
 *  . . . * . . . * . . . 
 *  . . . . * . * . . . . 
 *  . . . . . * . . . . . 
 *  . . . . * . * . . . . 
 *  . . . * . . . * . . . 
 *  . . * . . . . . * . . 
 *  . * . . . . . . . * . 
 *  * . . . . . . . . . * 
 *
 ******************************************************************************/

class Ex {

  public static void main(String[] args) { 
    int n = Integer.parseInt(args[0]);

    for (int i = -n; i <= n; i++) {
      for (int j = -n; j <= n; j++) {
        if ((i == -j) || (i == j)) System.out.print("* ");
        else                       System.out.print(". ");
      }
      System.out.println();
    }
  }
}