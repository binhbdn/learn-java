// https://www.hackerrank.com/challenges/java-bitset

import java.util.Scanner;
import java.util.BitSet;

class Solution414 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    BitSet[] B = new BitSet[]{new BitSet(N), new BitSet(N)};

    int M = scan.nextInt();
    String operation;
    int operand1;
    int operand2;

    for (int i=0;i<M;i++){
      operation = scan.next().toUpperCase();
      operand1 = scan.nextInt();
      operand2 = scan.nextInt();

      switch (operation){
        case "AND":
        case "OR":
        case "XOR":
          if (!((operand1==1)|(operand1==2))&&((operand2==1)|(operand2==2))) System.out.println("wrong operands input");
          break;
        case "FLIP":
        case"SET":
        if (!((operand1==1)|(operand1==2))&&((operand2>=0)|(operand2<N))) System.out.println("wrong operands input");
          break;
        default:
          System.out.println("wrong operation input");
      };

      switch (operation){
        case "AND":
          B[operand1-1].and(B[operand2-1]);
          break;
        case "OR":
          B[operand1-1].or(B[operand2-1]);
          break;
        case "XOR":
          B[operand1-1].xor(B[operand2-1]);
          break;
        case "FLIP":
          B[operand1-1].flip(operand2);
          break;
        default:/* "SET" */
          B[operand1-1].set(operand2);
      };

      System.out.println(B[0].cardinality()+" "+B[1].cardinality());
    };

    scan.close();
  }
}