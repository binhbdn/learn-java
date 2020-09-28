/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e8-Stewie2
BJP5 Exercise 1.8: Stewie2

Write a complete Java program in a class named Stewie2 that prints the following output. Use at least one static method besides main to remove redundancy.
//////////////////////
|| Victory is mine! ||
\\\\\\\\\\\\\\\\\\\\\\
|| Victory is mine! ||
\\\\\\\\\\\\\\\\\\\\\\
|| Victory is mine! ||
\\\\\\\\\\\\\\\\\\\\\\
|| Victory is mine! ||
\\\\\\\\\\\\\\\\\\\\\\
|| Victory is mine! ||
\\\\\\\\\\\\\\\\\\\\\\
*/
public class Stewie2{
    public static void main(String[] args){
        System.out.println("//////////////////////");
        SubStewie2();
        SubStewie2();
        SubStewie2();
        SubStewie2();
        SubStewie2();
    }
    private static void SubStewie2(){
        System.out.println("|| Victory is mine! ||");
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    }
}