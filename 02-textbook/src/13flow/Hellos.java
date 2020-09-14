/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/Hellos.java
 *
 *  Compilation:  javac Hellos.java
 *  Execution:    java Hellos n
 *
 *  Prints ith Hello for i = 1 to n.
 *
 *  % java Hellos
 *  1st Hello
 *  2nd Hello 
 *  3rd Hello
 *  4th Hello
 *  5th Hello
 *  6th Hello
 *  7th Hello
 *  8th Hello
 *  9th Hello
 *  10th Hello
 *  11th Hello
 *  12th Hello
 *  13th Hello
 *  14th Hello
 *  15th Hello
 *  16th Hello
 *  17th Hello
 *  18th Hello
 *  19th Hello
 *  20th Hello
 *  21st Hello
 *  22nd Hello
 *  23rd Hello
 *  24th Hello
 *
 ******************************************************************************/

class Hellos { 
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);

    for (int i = 1; i <= n; i++) {
      System.out.print(i);

      // ends in 11 through 20 -> use "th" as suffix
      if (i % 100 >= 11 && i % 100 <= 20) {
        System.out.print("th");
      }

      // otherwise if ends in { 1, 2, 3 } -> use { "st", "nd", "rd" }  as suffix
      else if (i % 10 == 1) System.out.print("st");
      else if (i % 10 == 2) System.out.print("nd");
      else if (i % 10 == 3) System.out.print("rd");

      // otherwise use "th" as suffix
      else                  System.out.print("th");

      System.out.println(" Hello");
    }
  }
}