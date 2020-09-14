/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/Euler.java
 *
 *  Compilation:  javac Euler.java
 *  Execution:    java Euler n
 *
 *  Tests whether there are any five positive integers that satisfy
 *  a^5 + b^5 + c^5 + d^5 = e^5. In 1769 Euler conjectured that no such
 *  solutions exists, but his conjecture was disproved in 1966 using
 *  a method like the one below.
 *
 *  The program reads in an integer command-line argument n and prints
 *  all solutions with a <= b <= c <= d <= e <= n. Restricting attention
 *  to solutions of this form only eliminates duplicates and makes
 *  the program faster since we have many fewer possibilities to try
 *  (675,993,780 vs. 75,937,500,000).
 *
 *  For further efficiency, we use the break statement to avoid explicitly
 *  enumerating certain tuples (a, b, c, d, e), e.g., if a^5 + b^5
 *  is already greater than e^5, there is no need to fix specific
 *  values of c and d and compute a^5 + b^5 + c^5 + d^5.
 *
 *  % java Euler 100
 *
 *  % java Euler 150
 *   27^5 + 84^5 + 110^5 + 133^5 = 144^5
 *
 *  % java Euler 500
 *  27^5 + 84^5 + 110^5 + 133^5 = 144^5
 *  54^5 + 168^5 + 220^5 + 266^5 = 288^5
 *  81^5 + 252^5 + 330^5 + 399^5 = 432^5
 *
 *
 ******************************************************************************/

class Euler {
  public static void main(String[] args) { 
    long n = Long.parseLong(args[0]);
    long a5, b5, c5, d5, e5, a5b5c5d5;

    for (long e = 1; e <= n; e++) {
      e5 = e*e*e*e*e;

      // restrict search to a <= b <= c <= d <= e for efficiency
      for (long a = 1; a <= n; a++) {
        a5 = a*a*a*a*a;
        if (a5*4 > e5) break;

        for (long b = a; b <= n; b++) {
          b5 = b*b*b*b*b;
          if (a5 + b5*3 > e5) break;

          for (long c = b; c <= n; c++) {
            c5 = c*c*c*c*c;
            if (a5 + b5 + c5*2 > e5) break;

            for (long d = c; d <= n; d++) {
              d5 = d*d*d*d*d;
              a5b5c5d5 = a5 + b5 + c5 + d5;
              if (a5b5c5d5  > e5) break;
              if (a5b5c5d5 == e5)
                System.out.println(a + "^5 + " + b + "^5 + " + c + "^5 + " + d + "^5 = " + e + "^5"); 
            }
          }
        }
      }
    }
  }
}