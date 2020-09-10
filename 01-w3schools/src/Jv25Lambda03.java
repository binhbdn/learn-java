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
// Create a method which takes a lambda expression as a parameter:

interface StringFunction {
    String run(String str);
}

class Jv25Lambda03 {
    public static void main(String[] args) {
        StringFunction exclaim = (s) -> s + "!";
        StringFunction ask = (s) -> s + "?";
        printFormatted("Hello", exclaim);
        printFormatted("Hello", ask);
    }

    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }
}
