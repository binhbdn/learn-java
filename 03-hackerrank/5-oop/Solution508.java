// https://www.hackerrank.com/challenges/java-iterator

import java.util.*;

class Solution508{
  static Iterator<Object> func(ArrayList<Object> mylist){
    Iterator<Object> it=mylist.iterator();
    while(it.hasNext()){
      Object element = it.next();
      if(element.equals("###"))
      break;
    }
    return it;
  }
  public static void main(String[] args){
    ArrayList<Object> mylist = new ArrayList<Object>();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    for(int i = 0;i<n;i++){
      mylist.add(sc.nextInt());
    }
    
    mylist.add("###");

    for(int i=0;i<m;i++){
      mylist.add(sc.next());
    }

    sc.close();
    
    Iterator<Object> it=func(mylist);

    while(it.hasNext()){
      Object element = it.next();
      System.out.println((String)element);
    }
  }
}