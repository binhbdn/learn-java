// https://www.hackerrank.com/challenges/java-static-initializer-block

import java.util.Scanner;

class Solution109 {
  static Scanner sc;
  static int B;
  static int H;
  static boolean flag;

  static {
    sc = new Scanner(System.in);
    B = sc.nextInt();
    H = sc.nextInt();
    flag = (B>0) && (H>0);
    if (!flag) System.out.println("java.lang.Exception: Breadth and height must be positive");
  }
  public static void main(String[] args){
    if(flag){
      int area=B*H;
      System.out.println(area);
    }
  }
}
