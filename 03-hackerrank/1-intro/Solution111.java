// https://www.hackerrank.com/challenges/java-date-and-time

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
// import java.io.*;
// import java.util.*;

class Result {
  /*
  Complete the 'findDay' function below.

  The function is expected to return a STRING.
  The function accepts following parameters:
   1. INTEGER month
   2. INTEGER day
   3. INTEGER year
  */

  public static String findDay(int month, int day, int year) {
    Calendar dt = Calendar.getInstance();
    dt.set(year, month-1, day);
    return dt.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
  }
}

public class Solution111 {
  public static void main(String[] args) throws IOException {
    System.out.println("Enter a date (Fomat: dd mm yyyy):");

    Scanner sc = new Scanner(System.in);
    int month = sc.nextInt();
    int day = sc.nextInt();
    int year = sc.nextInt();
    sc.close();

    String res = Result.findDay(month, day, year);
    System.out.println(res);

    /*
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int month = Integer.parseInt(firstMultipleInput[0]);
    int day = Integer.parseInt(firstMultipleInput[1]);
    int year = Integer.parseInt(firstMultipleInput[2]);

    String res = Result.findDay(month, day, year);

    bufferedWriter.write(res);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
    */
  }
}
