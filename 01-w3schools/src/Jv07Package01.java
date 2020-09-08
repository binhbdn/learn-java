// https://docs.oracle.com/javase/8/docs/api/
// import package.name.Class;   // Import a single class
// import package.name.*;   // Import the whole package

import java.util.Scanner;
// import java.util.*;
import jv07package.*;

class Jv07Package01 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");

        String userName = myObj.nextLine();
        myObj.close();

        System.out.println("Username is: " + userName);
        
        Jv07Package02.myStaticMethod();
        Jv07Package02 myObj2 = new Jv07Package02();
        myObj2.myPublicMethod();
      }
}
