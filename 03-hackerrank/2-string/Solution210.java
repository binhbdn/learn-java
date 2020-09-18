// https://www.hackerrank.com/challenges/duplicate-word

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution210/* DuplicateWords */ {
  public static void main(String[] args) {
    String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";/* Write a RegEx matching repeated words here. */
    Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE/* Insert the correct Pattern flag here.*/);

    Scanner in = new Scanner(System.in);
    int numSentences = Integer.parseInt(in.nextLine());
    
    while (numSentences-- > 0) {
      String input = in.nextLine();
      Matcher m = p.matcher(input);
      // Check for subsequences of input that match the compiled pattern
      while (m.find()) {
        input = input.replaceAll(m.group()/* The regex to replace */, m.group(1)/* The replacement. */);
      }
      // Prints the modified sentence.
      System.out.println(input);
    }
    in.close();
  }
}
/*
Regex: "\b(\w+)(?:\W+\1\b)+"    ->    "\\b(\\w+)(?:\\W+\\1\\b)+"

In Java, backslashes in strings need to be escaped themselves,
so two backslashes are needed to escape special characters.


\w    A word character: [a-zA-Z_0-9]

\W    A non-word character: [^\w]

\b    A word boundary
      boundaries are needed for special cases, such as
      "Bob and Andy" (we don't want to match "and" twice)
      "My thesis is great" (we don't want to match "is" twice).

\1    Matches whatever was matched in the 1st group of parentheses,
      which in this case is the (\w+)

+     Match whatever it's placed after 1 or more times

?:    is added to make it a "non-capturing group"
      meaning you can't do group() to get the group, for slightly faster performance.
*/