/******************************************************************************
 *  Compilation:  javac RandomPointInCircle.java
 *  Execution:    java RandomPointInCircle
 *  
 *  Prints a point chosen uniformly at random inside the circle centered
 *  at (0, 0) and of radius 1.
 *
 *  Uses rejection sampling and a do-while loop.
 *
 *  %  java RandomPointInCircle
 *  (0.14539046532309108,0.8977797581170848)
 *
 *  % java RandomPointInCircle
 *  (-0.6333174979488703,-0.49591305165817845)
 *
 ******************************************************************************/

class RandomPointInCircle {
  public static void main(String[] args) { 
    double x, y;
    do {
      // Scale x and y to be random in (-1, 1).
      x = 2.0 * Math.random() - 1.0;
      y = 2.0 * Math.random() - 1.0;
    } while (x*x + y*y > 1.0);

    // print (x, y)
    System.out.println("(" + x + "," + y + ")");
}
}