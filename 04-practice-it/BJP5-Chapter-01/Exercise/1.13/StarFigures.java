/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e13-StarFigures
BJP5 Exercise 1.13: StarFigures

Write a complete Java program in a class named StarFigures that generates the following output. Use static methods to show structure and eliminate redundancy in your solution.
*****
*****
 * *
  *
 * *

*****
*****
 * *
  *
 * *
*****
*****

  *
  *
  *
*****
*****
 * *
  *
 * *
*/
public class StarFigures{
    public static void main(String[] args){
        StarFigures_5x2_212();
        System.out.println();
        StarFigures_5x2_212();
        StarFigures_5x2_0111();
        StarFigures_5x2_212();
    }
    private static void StarFigures_1(){
        System.out.println("  *");
    }
    private static void StarFigures_2(){
        System.out.println(" * *");
    }
    private static void StarFigures_5(){
        System.out.println("*****");
    }
    private static void StarFigures_5x2(){
        StarFigures_5();
        StarFigures_5();
    }
    private static void StarFigures_212(){
        StarFigures_2();
        StarFigures_1();
        StarFigures_2();
    }
    private static void StarFigures_0111(){
        System.out.println();
        StarFigures_1();
        StarFigures_1();
        StarFigures_1();
    }
    private static void StarFigures_5x2_212(){
        StarFigures_5x2();
        StarFigures_212();
    }
    private static void StarFigures_5x2_0111(){
        StarFigures_5x2();
        StarFigures_0111();
    }
}