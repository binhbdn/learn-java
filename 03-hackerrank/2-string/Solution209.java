// https://www.hackerrank.com/challenges/java-regex

// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
import java.util.Scanner;

class Solution209 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      String IP = in.next();
      System.out.println(IP.matches(new MyRegex().pattern));
    }
    in.close();
  }
}

//Write your code here
class MyRegex{
  String zeroTo255 = "([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])";
  public String pattern = "(("+zeroTo255+"\\.){3}"+zeroTo255+")\\b";
  /* "((([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.){3}([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5]))\\b" */

  /*
  IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
  Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.

  String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
  String zeroTo255 = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])";

  public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
  */
}
