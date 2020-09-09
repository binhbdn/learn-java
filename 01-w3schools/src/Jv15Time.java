/*
Class               Description
LocalDate           yyyy-MM-dd
LocalTime           HH-mm-ss-ns (nanoseconds)
LocalDateTime       yyyy-MM-dd-HH-mm-ss-ns
DateTimeFormatter

ofPattern() method
yyyy-MM-dd          "1988-09-29"	
dd/MM/yyyy	        "29/09/1988"	
dd-MMM-yyyy	        "29-Sep-1988"	
E, MMM dd yyyy	    "Thu, Sep 29 1988"
*/

import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime; // import the LocalTime class
import java.time.LocalDateTime; // import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

class Jv15Time {
    public static void main(String[] args) {
        LocalDate myObj1 = LocalDate.now(); // Create a date object
        System.out.println(myObj1); // Display the current date

        LocalTime myObj2 = LocalTime.now();
        System.out.println(myObj2);

        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj);

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);
    }
}
