/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/Palindrome.java
 *
 *  Compilation:  javac Palindrome.java
 *  Execution:    java Palindrome n
 *
 *  Create a palindromic string.
 *
 *  % java Palindrome 1
 *  11
 *
 *  % java Palindrome 2
 *  11211
 *
 *  % java Palindrome 3
 *  3112113
 *
 *  % java Palindrome 4
 *  311211343112113
 *
 *  % java Palindrome 5
 *  53112113431121135
 *
 ******************************************************************************/

class Palindrome {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    String s = "";
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) s = s + i + s;
      else            s = i + s + i;
    }
    System.out.println(s);
  }
}