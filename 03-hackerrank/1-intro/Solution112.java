// https://www.hackerrank.com/challenges/java-currency-formatter

import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class Solution112 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double payment = scanner.nextDouble();
    scanner.close();
    // Write your code here.
    Locale indiaLocale = new Locale("en", "IN");

    String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
    String india = NumberFormat.getCurrencyInstance(indiaLocale).format(payment);
    String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
    String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

    System.out.println("US: " + us);
    System.out.println("India: " + india);
    System.out.println("China: " + china);
    System.out.println("France: " + france);
  }
}
