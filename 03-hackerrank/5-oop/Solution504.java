// https://www.hackerrank.com/challenges/java-interface

import java.util.Scanner;

interface AdvancedArithmetic{
  int divisor_sum(int n);
}

//Write your code here
class My_Calculator implements AdvancedArithmetic{
  public int divisor_sum(int n){
    int sum=0;
    int sqrt = (int) Math.sqrt(n);
    for (int i=1;i<=sqrt;i++) {
      if (n%i==0){ // if "i" is a divisor
        sum += i + n/i; // add both divisors
      }
    }
    // If sqrt is a divisor, we should only count it once
    if (sqrt * sqrt == n){
      sum -= sqrt;
    }
    return sum;
  }
}

class Solution504{
  public static void main(String []args){
    My_Calculator my_calculator = new My_Calculator();
    System.out.print("I implemented: ");
    ImplementedInterfaceNames(my_calculator);
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.print(my_calculator.divisor_sum(n) + "\n");
    sc.close();
  }
  
  // ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
  static void ImplementedInterfaceNames(Object o){
    Class<?>[] theInterfaces = o.getClass().getInterfaces();
    for (int i = 0; i < theInterfaces.length; i++){
      String interfaceName = theInterfaces[i].getName();
      System.out.println(interfaceName);
    }
  }
}