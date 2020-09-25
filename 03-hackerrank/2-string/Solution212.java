// https://www.hackerrank.com/challenges/tag-content-extractor

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution212 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
      String line = in.nextLine();
      
      boolean matchFound = false;
      Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
      Matcher m = p.matcher(line);

      while (m.find()) {
        System.out.println(m.group(2));
        matchFound = true;
      }
      if ( ! matchFound) {
        System.out.println("None");
      };
			
			testCases--;
    }
    in.close();
  }
}