// https://www.hackerrank.com/challenges/java-bigdecimal

import java.util.Scanner;
import java.math.BigDecimal;

class Solution303{
  public static void main(String []args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] s = new String[n+2];
    for(int i=0;i<n;i++){
      s[i] = sc.next();
    }
    sc.close();
    // Sort numbers with bubble sort
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n-i); j++) {
        BigDecimal sj = new BigDecimal(s[j]);
        BigDecimal sj1 = new BigDecimal(s[j-1]);
        if(sj.compareTo(sj1) == 1){
          String temp = s[j];
          s[j] = s[j-1];
          s[j-1] = temp;
        }
      }       
      }
    //Output
    for(int i=0;i<n;i++){
      System.out.println(s[i]);
    }
  }
}