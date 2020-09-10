/*java.util.regex package ncludes the following classes:
      Pattern Class - Defines a pattern (to be used in a search)
      Matcher Class - Used to search for the pattern
      PatternSyntaxException Class - Indicates syntax error in a regular expression pattern

Expression	    Description
[abc]	          Find one character from the options between the brackets
[^abc]	        Find one character NOT between the brackets
[0-9]	          Find one character from the range 0 to 9

Metacharacter	  Description
|	              Find a match for any one of the patterns separated by | as in: cat|dog|fish
.	              Find just one instance of any character
^	              Finds a match as the beginning of a string as in: ^Hello
$	              Finds a match at the end of the string as in: World$
\d	            Find a digit
\s	            Find a whitespace character
\b	            Find a match at the beginning of a word like this: \bWORD, or at the end of a word like this: WORD\b
\\uxxxx	        Find the Unicode character specified by the hexadecimal number xxxx
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Jv23RegEx {
    public static void main(String[] args) {
        /*  Flags in the compile() method
                Pattern.CASE_INSENSITIVE
                Pattern.LITERAL
                Pattern.UNICODE_CASE - Use it together with the CASE_INSENSITIVE    */
        Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Visit W3Schools!");
        boolean matchFound = matcher.find();
        if(matchFound) {
          System.out.println("Match found");
        } else {
          System.out.println("Match not found");
        }
    }
}
