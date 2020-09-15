/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/Pepys.java
 *
 *  Compilation:  javac Pepys.java
 *  Execution:    java Pepys k trials
 *
 *  Which is more likely: at least one 1 in 6 rolls of a fair die,
 *  or at least two 1s in 12 rolls of a fair die?
 *
 *  This program takes two integer command-line arguments k and trials,
 *  and repeats the following experiment trials times:
 *      - roll 6k dice
 *      - count number of 1s
 *      - success = at least k 1s
 *
 *  % java Pepys 1 10000000
 *  0.6651856
 *
 *  % java Pepys 2 10000000
 *  0.6186818
 *
 *  % java Pepys 1000 100000
 *  0.50647
 *
 *  The exact answer is 1 - (5/6)^6 = 31031/46656 for k = 1,
 *  1346704211/2176782336 for k = 2, and
 *  1/2 as k approaches infinity.
 *
 *  Reference: https://en.wikipedia.org/wiki/Newton–Pepys_problem
 *
 *  Use for live coding.
 *    - forget to type command line arguments
 *    - to start: do experiment assuming k = 1
 *    - declare and initialize ones outside loop
 *      (so that it never gets reset to 0)
 *    - Put in extra ; after if statement.
 *    - Integer division (r < 1/6)
 *    - Insert System.out.println() in loop for debugging
 *    - forget to recompile
 *    - add command-line argument k (but use Integer.parseInt(args[0]) again)
 *    - named constant for number of sides of dice
 *    - forget curly braces around outer for loop
 *
 ******************************************************************************/

class Pepys { 
  public static void main(String[] args) {
    int SIDES = 6;    // number of sides on a die

    // roll a fair die 6k times, seeking k 6s
    int k = Integer.parseInt(args[0]);

    // number of times to repeat each experiment
    int trials = Integer.parseInt(args[1]);

    // repeat experiment and count successes
    int count = 0;
    for (int t = 1; t <= trials; t++) {

      // number of 1s in 6k rolls
      int ones = 0;
      for (int i = 0; i < k * SIDES; i++) {
        double r = Math.random();
        if (r < 1.0 / SIDES)
          ones++;
      }
      if (ones >= k) count++;
    }

    // print fraction of successes
    System.out.println(1.0 * count / trials);
  }
}