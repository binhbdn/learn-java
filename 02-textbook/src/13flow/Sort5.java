/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/Sort5.java
 *
 *  Compilation:  javac Sort5.java
 *  Execution:    java Sort5 A B C D E
 *
 *  Reads in five integers and prints them out in sorted order without
 *  using a loop.
 *
 *  % java Sort5 33 22 18 66 43
 *  18 22 33 43 66
 *
 *  % java Sort5 43 22 18 22 33
 *  18 22 22 33 43
 *
 *  % java Sort5 43 12 8 4 1
 *  1 4 8 12 43
 *
 ******************************************************************************/

class Sort5 { 
  public static void main(String[] args) { 
    int A = Integer.parseInt(args[0]);
    int B = Integer.parseInt(args[1]);
    int C = Integer.parseInt(args[2]);
    int D = Integer.parseInt(args[3]);
    int E = Integer.parseInt(args[4]);

    if (A > B) { int t = A; A = B; B = t; } // A <= B
    if (D > E) { int t = D; D = E; E = t; } // A <= B ; D <= E
    if (A > C) { int t = A; A = C; C = t; } // A <= BC ; D <= E
    if (B > C) { int t = B; B = C; C = t; } // A <= B <= C ; D <= E
    if (A > D) { int t = A; A = D; D = t; } // A <= BCDE; B <= C
    if (C > D) { int t = C; C = D; D = t; } // A <= BCDE; BC <= D
    if (B > E) { int t = B; B = E; E = t; } // A <= BCDE; B < DE; C <= D
    if (B > C) { int t = B; B = C; C = t; } // A <= B <= C <= DE
    if (D > E) { int t = D; D = E; E = t; } // A <= B <= C <= D <= E

    System.out.println(A + " " + B + " " + C + " " + D + " " + E);
  }
}