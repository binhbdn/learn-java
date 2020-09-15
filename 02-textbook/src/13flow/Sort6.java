/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/Sort6.java
 *
 *  Compilation:  javac Sort6.java
 *  Execution:    java Sort6 a b c d e f
 *
 *  Reads in six integers and prints them out in sorted order without
 *  using a loop. Uses 12 compare-exchanges.
 *
 *  Solution submitted by Sailesh Dhungana '11.
 *
 ******************************************************************************/

class Sort6 { 
  public static void main(String[] args) {

    // read in 6 command-line integers to sort
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = Integer.parseInt(args[2]);
    int d = Integer.parseInt(args[3]);
    int e = Integer.parseInt(args[4]);
    int f = Integer.parseInt(args[5]);
                                            // < mean shorthand of <= :
    if (a > b) { int t = b; b = a; a = t; } //01. a<b;
    if (c > d) { int t = d; d = c; c = t; } //02. a<b; c<d;
    if (e > f) { int t = f; f = e; e = t; } //03. a<b; c<d; e<f; min=ace; max=bdf;
    if (c > e) { int t = e; e = c; c = t; } //04. a<b; c<def; min=ac; max=bdf;
    if (a > c) { int t = c; c = a; a = t; } //05. min1=a; max=bdf;
    if (b > d) { int t = d; d = b; b = t; } //06. min1=a; b<d; max=df;
    if (d > f) { int t = f; f = d; d = t; } //07. min1=a; max1=f;
    if (b > c) { int t = c; c = b; b = t; } //08. min1=a; b<c; max1=f;
    if (d > e) { int t = e; e = d; d = t; } //09. min1=a; b<c; d<e; min2=bd; max2=ce; max1=f;
    if (b > d) { int t = d; d = b; b = t; } //10. min1=a; min2=b; max2=ce; max1=f;
    if (c > e) { int t = e; e = c; c = t; } //11. min1=a; min2=b; max2=e; max1=f;
    if (c > d) { int t = d; d = c; c = t; } //12. min1=a; min2=b; min3=c; max3=d; max2=e; max1=f;
    System.out.println(a + " " + b + " " + c+ " " + d+ " " + e   + " " + f);
  }
}