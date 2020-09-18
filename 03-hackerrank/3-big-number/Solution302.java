// https://www.hackerrank.com/challenges/java-primality-test
// https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#isProbablePrime%28int%29

import java.util.Scanner;
import java.math.BigInteger;

class Solution302 {
  private static final Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    BigInteger n = scanner.nextBigInteger();
    scanner.close();
    System.out.println(n.isProbablePrime(5) ? "prime" :"not prime");
  }
}