/******************************************************************************
 *  Compilation:  javac Cos.java
 *  Execution:    java Cos x
 *
 *  Prints out cos(x) using Taylor expansion.
 *  
 *     cos x = 1 - x^2/2! + x^4/4! - x^6/6! + ...
 *
 *  $ java Cos 1.047197551
 *  0.5000000001702586
 *
 *  Note:  cos(pi/3) = cos(1.047197551...) = 1/2
 *
 *  We use identity cos(x) = cos(x + 2 PI) to pre-process
 *  x to be between -2 PI and 2 PI. Yes, % works with doubles!
 *
 ******************************************************************************/

class Cos {
  public static void main(String[] args) { 
    double x = Double.parseDouble(args[0]);

    // convert x to an angle between -2 PI and 2 PI
    x = x % (2 * Math.PI);

    // compute the Taylor series approximation
    double term = 1.0;      // ith term = x^i / i!
    double sum  = 1.0;      // sum of first i terms in taylor series

    for (int i = 1; term != 0.0; i++) {
      term *= (x / i);
      if (i % 4 == 0) sum += term;
      if (i % 4 == 2) sum -= term;
    }
    System.out.println(sum);
  }
}