/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/13flow/ISBN2.java
 *
 *  Compilation:  javac ISBN2.java
 *  Execution:    java ISBN2 n
 *
 *  Determines the check digit of an ISBN number given the first 9 digits.
 *  Prints out the fully formatted ISBN number.
 *
 *  An ISBN number is legal if it consists of 10 digits and
 *  d_1 + 2*d_2 + 3*d_3 + ... + 10*d_10 is a multiple of 11.
 *  For example, 0-201-31452-5 is legal since
 *  1*5 + 2*2 + 3*5 + 4*4 + 5*1 + 6*3 + 7*1 + 8*0 + 9*2 + 10*0 = 88
 *  and 88 is a multiple of 11.
 *
 *  %  java ISBN2 020131453
 *  0-201-31453-3
 *
 *  % java ISBN2 020131454
 *  0-201-31454-1
 *
 *  % java ISBN2 020131455
 *  0-201-31455-X
 *
 ******************************************************************************/

class ISBN2 {

  public static void main(String[] args) { 
    int n = Integer.parseInt(args[0]);
    String isbn = "";

    int sum = 0;
    for (int i = 2; i <= 10; i++) {
      int digit = n % 10;
      if (i == 2 || i == 7 || i == 10) isbn = "-" + isbn;
      isbn = digit + isbn;
      sum += i * digit;
      n = n / 10;
    }
  
    // print out check digit, use X for 10
    if (sum % 11 == 1)      isbn += "X";
    else if (sum % 11 == 0) isbn += "0";
    else                    isbn += (11 - sum % 11);

    System.out.println(isbn);
  }
}