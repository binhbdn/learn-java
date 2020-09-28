/*
https://practiceit.cs.washington.edu/problem/view/bjp5/chapter1/e17-FarewellGoodBye
BJP5 Exercise 1.17: FarewellGoodBye

Write a program called FarewellGoodBye that prints the following lyrics. Use static methods to show structure and eliminate redundancy in your solution.
Farewell,
goodbye,
au revoir,
good night!
It's time, to go,
and I'll be out of sight!

Farewell,
goodbye,
au revoir,
take care!
I'll say, goodbye,
that's neither here nor there!

Farewell,
goodbye,
au revoir,
see you later!
I hope, you think,
I'm a lover, not a hater!
*/
public class FarewellGoodBye {
    public static void main(String[] args){
        FarewellGoodBye_1();
        FarewellGoodBye_2a();
        FarewellGoodBye_1();
        FarewellGoodBye_2b();
        FarewellGoodBye_1();
        FarewellGoodBye_2c();
    }
    private static void FarewellGoodBye_1(){
        System.out.println("Farewell,");
        System.out.println("goodbye,");
        System.out.println("au revoir,");
    }
    private static void FarewellGoodBye_2a(){
        System.out.println("good night!");
        System.out.println("It's time, to go,");
        System.out.println("and I'll be out of sight!");
        System.out.println();
    }
    private static void FarewellGoodBye_2b(){
        System.out.println("take care!");
        System.out.println("I'll say, goodbye,");
        System.out.println("that's neither here nor there!");
        System.out.println();
    }
    private static void FarewellGoodBye_2c(){
        System.out.println("see you later!");
        System.out.println("I hope, you think,");
        System.out.println("I'm a lover, not a hater!");
    }
}