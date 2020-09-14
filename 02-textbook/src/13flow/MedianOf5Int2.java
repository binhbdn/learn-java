// Write a program that takes five integer command-line arguments and prints the median
//(the third largest one)
// (hard) Now, try to compute the median of 5 elements such that when executed,
// it never makes more than 6 total comparisons.

class MedianOf5Int2 { 
  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = Integer.parseInt(args[2]);
    int d = Integer.parseInt(args[3]);
    int e = Integer.parseInt(args[4]);
    int tmp;

    // makes a <= b and c <= d
    if(a > b){tmp = a; a = b; b = tmp;}
    if(c > d){tmp = c; c = d; d = tmp;}

    // eleminate the lowest
    if(a > c){
      tmp = b; b = d; d = tmp; 
      c = a; //result: a <= c <= d
    }

    // gets e in
    a = e;

    // makes a <= b
    if(a > b){tmp = a; a = b; b = tmp;}

    // eliminate another lowest
    // remaing: a,b,d
    if(a < c){
      tmp = b; b = d; d = tmp; 
      a = c;
    }

    if(d < a)
      System.out.println(d);
    else
      System.out.println(a);
  }
}