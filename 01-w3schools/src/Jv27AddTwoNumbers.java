import java.util.Scanner; // Import the Scanner class

class Jv27AddTwoNumbers {
    public static void main(String[] args) {
        int x, y, sum;
        Scanner myObj = new Scanner(System.in); // Create a Scanner object

        System.out.print("\033[H\033[2J");
        // System.out.flush();

        System.out.println("This program will add two integer numbers");
        System.out.println("Please input first integer number:");
        x = myObj.nextInt(); // Read user input
    
        System.out.println("Please input second integer number:");
        y = myObj.nextInt(); // Read user input

        myObj.close(); // Close Scanner object
    
        sum = x + y;  // Calculate the sum of x + y
        System.out.println("Sum of " + x + " and " + y + " is " + sum); // Print the sum
    }
}
