/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/12types/Distance.java.html
 *
 *  Compilation:  javac Distance.java
 *  Execution:    java Distance x y
 *
 *  Prints the distance from (x, y) to the origin, where x and y
 *  are integers.
 *
 *  % java Distance 3 4
 *  distance from (3, 4) to (0, 0) = 5.0
 *
 *  % java Distance 5 12
 *  distance from (5, 12) to (0, 0) = 13.0
 *
 *  % java Distance 2 1
 *  distance from (2, 1) to (0, 0) = 2.23606797749979
 *
 ******************************************************************************/

class Distance {
  public static void main(String[] args) {

    // parse x- and y-coordinates from command-line arguments
    int x = Integer.parseInt(args[0]);
    int y = Integer.parseInt(args[1]);

    // compute distance to (0, 0)
    double dist = Math.sqrt(x*x + y*y);

    // output distance
    System.out.println("distance from (" + x + ", " + y + ") to (0, 0) = " + dist);
  }   
}