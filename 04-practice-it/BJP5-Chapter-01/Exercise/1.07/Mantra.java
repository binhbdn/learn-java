/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e7-Mantra
BJP5 Exercise 1.7: Mantra

Write a complete Java program in a class named Mantra that produces the following output. Remove its redundancy by adding a method.
There's one thing every coder must understand:
The System.out.println command.

There's one thing every coder must understand:
The System.out.println command.
*/
public class Mantra{
    public static void main(String[] args){
        SubMantra();
        System.out.println();
        SubMantra();
    }
    public static void SubMantra(){
        System.out.println("There's one thing every coder must understand:");
        System.out.println("The System.out.println command.");
    }
}