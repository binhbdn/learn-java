// https://www.hackerrank.com/challenges/java-exception-handling-try-catch

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArithmeticException;

class Solution601{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    try {
      int x = scan.nextInt();
      int y = scan.nextInt();
      System.out.println(x/y);
    } catch (InputMismatchException e){
      System.out.println(e.getClass().getName());
    } catch (ArithmeticException e){
      System.out.println(e.getClass().getName() + ": / by zero");
    };
    scan.close();
  }
}