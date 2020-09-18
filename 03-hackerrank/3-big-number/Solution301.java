// https://www.hackerrank.com/challenges/java-biginteger

import java.util.Scanner;
import java.math.BigInteger;

class Solution301 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    BigInteger bi1 = sc.nextBigInteger();
    BigInteger bi2 = sc.nextBigInteger();

    // BigInteger bi1 = new BigInteger(sc.next());
    // BigInteger bi2 = new BigInteger(sc.next());
    
    sc.close();

    BigInteger  bi3, bi4;
    bi3 = bi1.add(bi2);
    bi4 = bi1.multiply(bi2);

    System.out.println( bi3);
    System.out.println( bi4);
  }
}
