// https://www.hackerrank.com/challenges/java-anagrams

import java.util.Scanner;
import java.util.Arrays;

class Solution205 {
  static boolean isAnagram(String a, String b) {
    // Complete the function
    int lena = a.length();
    int lenb = b.length();
    if (lena != lenb) return false;

    char A[]=a.toLowerCase().toCharArray();
    char B[]=b.toLowerCase().toCharArray();

    Arrays.sort(A);
    Arrays.sort(B);

   return Arrays.equals(A,B);
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String a = scan.next();
    String b = scan.next();
    scan.close();
    boolean ret = isAnagram(a, b);
    System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
  }
}