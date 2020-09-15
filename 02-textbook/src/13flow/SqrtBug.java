/******************************************************************************
 *  Compilation:  javac SqrtBug.java
 *  Execution:    java SqrtBug c
 *  
 *  Computes the square root of a nonnegative number c using
 *  Newton's method:
 *     - initialize t = c
 *     - replace t with the average of c/t and t
 *     - repeat until desired accuracy reached [USING WRONG CONDITION]
 * 
 *  % java SqrtBug 2
 *  1.414213562373095
 *
 *  % java SqrtBug 1000000
 *  1000.0
 *  
 *  % java SqrtBug 0.4
 *  0.6324555320336759
 *  
 *  % java SqrtBug 1048575
 *  1023.9995117186336
 *
 *  % java SqrtBug 0
 *  0.0
 *
 *  % java SqrtBug 16664444
 *  [infinite loop]
 *
 *  % java SqrtBug 1e-50
 *  1.0E-50
 *  [wrong answer]
 *
 *
 *
 *  Known bugs
 *  ----------
 *   - use the loop-continuation condition in Sqrt.java for reliable
 *     results
 *
 ******************************************************************************/

class SqrtBug { 
  public static void main(String[] args) { 

    // read in the command-line argument
    double c = Double.parseDouble(args[0]);

    double t = c;              // estimate of the square root of c
    double EPSILON = 1e-15;    // relative error tolerance

    // repeatedly apply Newton update step until desired precision is achieved
    while (Math.abs(t*t - c) > EPSILON) {
      t = (c/t + t) / 2.0;
    }

    // print out the estimate of the square root of c
    System.out.println(t);
  }
}