/*Java Lambda Expressions : from Java 8
    - short block of code
    - takes in parameters and returns a value (similar to methods)
    - do not need a name
    - can be implemented right in the body of a method
Syntax:
    parameter -> expression
    (parameter1, parameter2) -> expression
    (parameter1, parameter2) -> { code block }
Lambda expressions can be stored in variables if:
    the variable's type is an interface which has only one method
    have the same number of parameters
    and the same return type as that method
To use a lambda expression in a method:
    the method should have a parameter with a single-method interface as its type
*/

// Example
// Use a lamba expression in the ArrayList's forEach() method to print every item in the list:

import java.util.ArrayList;

class Jv25Lambda01 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach( (n) -> { System.out.println(n); } );
    }
}
