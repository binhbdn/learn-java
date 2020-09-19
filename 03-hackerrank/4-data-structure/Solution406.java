// https://www.hackerrank.com/challenges/java-list

import java.util.Scanner;
import java.util.LinkedList;
class Solution406 {
  public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    int N=scan.nextInt(); // the initial number of elements in L

    LinkedList<Integer> L = new LinkedList<Integer>();
    for (int i=0;i<N;i++){
      int value=scan.nextInt();
      L.add(value);
    };

    int Q=scan.nextInt(); // the number of queries

    for (int i=0;i<Q;i++){
      String queryType=scan.next();
      if (queryType.equalsIgnoreCase("insert")){
        int index=scan.nextInt();
        int element=scan.nextInt();
        L.add(index, element);
      }else if (queryType.equalsIgnoreCase("delete")){
        int index=scan.nextInt();
        L.remove(index);
      }else{
        System.out.println("Wrong query.Please use \"insert\" or \"delete\".");
      };
    };
    scan.close();

    for (int i : L) {
      System.out.print(i+" ");
    };
  }
}
