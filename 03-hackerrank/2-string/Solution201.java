// https://www.hackerrank.com/challenges/java-strings-introduction

<<<<<<< HEAD
import java.util.Scanner;

class Solution201 {
=======
import java.util.*;

public class Solution201 {
>>>>>>> 625db3ded25f59626ec26621380b9cacaefa6086
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String A=sc.next();
    String B=sc.next();
    /* Enter your code here. Print output to STDOUT. */
    sc.close();
    System.out.println(A.length()+B.length());
    System.out.println(A.compareTo(B)>0?"Yes":"No");
    /*
    if (A.compareTo(B)>0) {
      System.out.println("Yes");
    } else {
       System.out.println("No");
    };
    */
    System.out.println(A.substring(0, 1).toUpperCase()+A.substring(1)+" "+B.substring(0, 1).toUpperCase()+B.substring(1));
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> 625db3ded25f59626ec26621380b9cacaefa6086
