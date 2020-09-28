/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e16-Shining
BJP5 Exercise 1.16: Shining

Write a program in a class named Shining that prints the following line of output 1000 times:
All work and no play makes Jack a dull boy.
You should not write a program whose source code is 1000 lines long; use methods to shorten the program. What is the shortest program you can write that will produce the 1000 lines of output, using only the material from Chapter 1 (println, methods, etc.)?
*/
public class Shining {
    public static void main(String[] args){
        Shining_200();
        Shining_200();
        Shining_200();
        Shining_200();
        Shining_200();
    }
    private static void Shining_200(){
        Shining_40();
        Shining_40();
        Shining_40();
        Shining_40();
        Shining_40();
    }
    private static void Shining_40(){
        Shining_8();
        Shining_8();
        Shining_8();
        Shining_8();
        Shining_8();
    }
    private static void Shining_8(){
        Shining_2();
        Shining_2();
        Shining_2();
        Shining_2();
    }
    private static void Shining_2(){
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
    }
}