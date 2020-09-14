/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/DigitReverser.java
 *
 *  Compilation:  javac DigitReverser.java
 *  Execution:    java DigitReverser n
 *
 *  Reverses the digits of a positive integer n using arithmetic. Then,
 *  reverse it again using string concatenation.
 *
 *  % java DigitReverser 123456789
 *  987654321
 *  123456789
 *
 ******************************************************************************/

class DigitReverser {
  public static void main(String[] args) { 
    int n = Integer.parseInt(args[0]);        // original integer

    // reverse using arithmetic
    int m = 0;
    while (n != 0) {
      m = (10 * m) + (n % 10);
      n = n / 10;
    }
    System.out.println(m);

    // reverse again using string concatenation
    String s = "";
    while (m != 0) {
      int digit = m % 10;
      s = s + digit;
      m = m / 10;
    }
    System.out.println(s);
  }
}