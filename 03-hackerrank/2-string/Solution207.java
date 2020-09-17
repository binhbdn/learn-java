// https://www.hackerrank.com/challenges/java-string-tokens

import java.util.Scanner;

public class Solution207 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    if(!scan.hasNext()) {scan.close(); System.out.print(0);return;}
    String s = scan.nextLine();
    scan.close();

    int len = s.length();
    if (len == 0) {
      System.out.println("0");
    } else if (len <= 400000) {
      String[] a = s.trim().split("[\\s!,?._'@]+");
      System.out.println(a.length);
      for (int i=0; i<a.length; i++) {
        System.out.println(a[i]);
      };
    };
  }
}