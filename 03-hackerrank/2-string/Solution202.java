// https://www.hackerrank.com/challenges/java-substring

import java.util.Scanner;

class Solution202 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String S = in.next();
    int start = in.nextInt();
    int end = in.nextInt();
    in.close();
    System.out.println(S.substring(start, end));
  }
}