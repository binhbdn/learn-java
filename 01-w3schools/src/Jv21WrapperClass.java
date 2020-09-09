/*
Java Wrapper Classes
Wrapper classes provide a way to use primitive data types as objects

Primitive Data      Type Wrapper Class
    byte	            Byte
    short	            Short
    int	                Integer
    long	            Long
    float	            Float
    double	            Double
    boolean	            Boolean
    char	            Character
*/


class Jv21WrapperClass {
    public static void main(String[] args) {
        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt);
        System.out.println(myDouble);
        System.out.println(myChar);
        System.out.println("----------");

        /*
        methods are used to get the value associated with the corresponding wrapper object:
        intValue(), byteValue(), shortValue(), longValue(),
        floatValue(), doubleValue(), charValue(), booleanValue()
        */
        System.out.println(myInt.intValue());
        System.out.println(myDouble.doubleValue());
        System.out.println(myChar.charValue());
        System.out.println("----------");

        // toString() method:
        System.out.println(myDouble.toString());
        System.out.println(myDouble.toString().length());
    }
}
