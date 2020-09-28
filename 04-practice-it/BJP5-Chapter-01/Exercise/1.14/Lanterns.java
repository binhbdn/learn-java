/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e14-Lanterns
BJP5 Exercise 1.14: Lanterns

Write a complete Java program in a class named Lanterns that generates the following three figures of output. Use static methods to show structure and eliminate redundancy in your solution.

In particular, make sure that main contains no System.out.println statements except for blank lines, that any System.out.println statement(s) repeated are captured in a method that is called just once, and that the same System.out.println statement never appears in two places in the code.
    *****
  *********
*************

    *****
  *********
*************
* | | | | | *
*************
    *****
  *********
*************

    *****
  *********
*************
    *****
* | | | | | *
* | | | | | *
    *****
    *****
*/
public class Lanterns{
    public static void main(String[] args){
        Lanterns_5913X2();
        Lanterns_2();
        Lanterns_13();
        Lanterns_5913X2();
        Lanterns_5();
        Lanterns_2();
        Lanterns_2();
        Lanterns_5();
        Lanterns_5();
    }
    private static void Lanterns_2(){
        System.out.println("* | | | | | *");
    }
    private static void Lanterns_5(){
        System.out.println("    *****");
    }
    private static void Lanterns_9(){
        System.out.println("  *********");
    }
    private static void Lanterns_13(){
        System.out.println("*************");
    }
    private static void Lanterns_5913(){
        Lanterns_5();
        Lanterns_9();
        Lanterns_13();
    }
    private static void Lanterns_5913X2(){
        Lanterns_5913();
        System.out.println();
        Lanterns_5913();
    }
}