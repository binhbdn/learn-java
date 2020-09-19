// https://www.hackerrank.com/challenges/java-negative-subarray

import java.util.Scanner;

class Solution403 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    int[] a = new int[n];
    for (int i=0;i<n;i++){
      a[i] = scan.nextInt();
    }
    scan.close();

    int sum;
    int count = 0;
    for (int subArrSize = 1; subArrSize <= n; subArrSize++){
      for (int i=0; i<=n-subArrSize; i++){
        sum = 0;
        for (int j=0; j<subArrSize; j++){
          sum += a[i+j];
        };
        if (sum < 0) count++;
      }
    }

    System.out.println(count);
  }
}

