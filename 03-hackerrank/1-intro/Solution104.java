// https://www.hackerrank.com/challenges/java-stdin-stdout

import java.util.Scanner;

class Solution104 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();
    scan.nextLine();
    double d = scan.nextDouble();
    scan.nextLine();
    String s = scan.nextLine();
    scan.close();

    System.out.println("String: " + s);
    System.out.println("Double: " + d);
    System.out.println("Int: " + i);
  }
}
