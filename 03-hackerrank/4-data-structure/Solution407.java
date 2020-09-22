// https://www.hackerrank.com/challenges/phone-book

import java.util.Scanner;
import java.util.HashMap;
class Solution407 {
  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
    in.nextLine();
    HashMap<String, Integer> phoneBook = new HashMap<String, Integer>();
		for(int i=0;i<n;i++){
			String name=in.nextLine();
			int phone=in.nextInt();
      in.nextLine();
      phoneBook.put(name, phone);
		}
		while(in.hasNext()){
      String s=in.nextLine();
      if (phoneBook.get(s)==null){
        System.out.println("Not found");
      }else{
        System.out.println(s+"="+phoneBook.get(s));
      };
    };
    in.close();
  }
}
