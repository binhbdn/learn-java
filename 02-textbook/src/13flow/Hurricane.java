/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/Hurricane.java
 *
 *  Compilation:  javac Hurricane.java
 *  Execution:    java Hurricane N
 *
 *  Reads in the wind speed (in miles per hour) and reports whether it is
 *  a hurricane, and if so, whether it is Class 1, 2, 3, 4 or 5 according
 *  to the Saffir-Simpson scale.
 *
 *  Reference: http://www.marinewaypoints.com/marine/wind.shtml
 *
 *  % java Hurricane 25
 *  Not a hurricane
 *
 *  % java Hurricane 135
 *  Class 4 hurricane
 *
 ******************************************************************************/

class Hurricane {
  public static void main(String[] args) { 
    int windSpeed = Integer.parseInt(args[0]);

    if      (windSpeed <  65) System.out.println("Not a hurricane");
    else if (windSpeed <  96) System.out.println("Class 1 hurricane");      
    else if (windSpeed < 111) System.out.println("Class 2 hurricane");      
    else if (windSpeed < 131) System.out.println("Class 3 hurricane");      
    else if (windSpeed < 155) System.out.println("Class 4 hurricane");      
    else                      System.out.println("Class 5 hurricane");      
  }
}